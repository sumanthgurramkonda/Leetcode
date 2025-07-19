class Solution {
    class Node{
        int val ;
        int delay;
        Node(){

        }
        Node(int val, int delay){
            this.val = val;
            this.delay = delay;
        }
        @Override
        public String toString() {
            return "Node{" + "val=" + val + ", delay=" + delay + '}';
        }
    }

    Map<Integer,List<Node>> adjListMap = new HashMap();
    Map<Integer, Integer> delayMap = new HashMap();
    public int networkDelayTime(int[][] times, int n, int k) {
        // if(n==k)return -1;
        for(int i=0;i<times.length;i++){
            int u = times[i][0];
            int v = times[i][1];
            int w = times[i][2];
            if(adjListMap.containsKey(u)){
               adjListMap.get(u).add(new Node(v,w)); 
            }else{
                List<Node> list = new LinkedList();
                list.add(new Node(v,w));
                adjListMap.put(u,list);
            }
        }
        networkDelayTime(k,0);
        if(delayMap.size()!=n)return -1;
        int res = 0;
        delayMap.forEach((key,value)->{
            System.out.println("key : "+key+" value : "+value);
        });
        for(int delay : delayMap.values()){
            res = Math.max(res,delay);
        }
        return res;
        
    }
    
    public void networkDelayTime(int n, int delay){
        if(delayMap.containsKey(n) && delay>=delayMap.get(n))return;
        delayMap.put(n,delay);
        if(!adjListMap.containsKey(n)) return;
        for(Node node : adjListMap.get(n)){
            networkDelayTime(node.val,delay+node.delay);
        }
    }
    
}


// class Solution {
//     class Node {
//         int val, delay;
//         Node(int val, int delay) {
//             this.val = val;
//             this.delay = delay;
//         }
//     }

//     Map<Integer, List<Node>> adjListMap = new HashMap<>();
//     Map<Integer, Integer> minDelayMap = new HashMap<>();

//     public int networkDelayTime(int[][] times, int n, int k) {
//         for (int[] time : times) {
//             int u = time[0], v = time[1], w = time[2];
//             adjListMap.computeIfAbsent(u, x -> new ArrayList<>()).add(new Node(v, w));
//         }

//         dfs(k, 0);

//         if (minDelayMap.size() != n) return -1;

//         int maxDelay = 0;
//         for (int time : minDelayMap.values()) {
//             maxDelay = Math.max(maxDelay, time);
//         }
//         return maxDelay;
//     }

//     private void dfs(int node, int delay) {
//         if (minDelayMap.containsKey(node) && delay >= minDelayMap.get(node)) {
//             return;
//         }
//         minDelayMap.put(node, delay);

//         if (!adjListMap.containsKey(node)) return;
//         for (Node neighbor : adjListMap.get(node)) {
//             dfs(neighbor.val, delay + neighbor.delay);
//         }
//     }
// }



