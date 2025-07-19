// class Solution {
//     class Node{
//         int val ;
//         int delay;
//         Node(){

//         }
//         Node(int val, int delay){
//             this.val = val;
//             this.delay = delay;
//         }
//         @Override
//         public String toString() {
//             return "Node{" + "val=" + val + ", delay=" + delay + '}';
//         }
//     }

//     Map<Integer,List<Node>> adjListMap = new HashMap();
//     Set<Integer> visited = new HashSet();
//     public int networkDelayTime(int[][] times, int n, int k) {
//         // if(n==k)return -1;
//         for(int i=0;i<times.length;i++){
//             int u = times[i][0];
//             int v = times[i][1];
//             int w = times[i][2];
//             if(adjListMap.containsKey(u)){
//                adjListMap.get(u).add(new Node(v,w)); 
//             }else{
//                 List<Node> list = new LinkedList();
//                 list.add(new Node(v,w));
//                 adjListMap.put(u,list);
//             }
//         }
//         List<Node> list = adjListMap.getOrDefault(k,new ArrayList());
//         for(Node node : list){
//             dfs(node.val, node.delay,n);
//         }
//         // dfs(k,0,n);
//         return res == Integer.MAX_VALUE ? -1 : res;
//     }
//     int res = Integer.MAX_VALUE;
//     public void dfs(int num, int delay, int n){
//         if(visited.contains(num)) return;
//         if(num==n){
//             res = Math.min(res,delay);
//         }
//         List<Node> list = adjListMap.getOrDefault(num,new ArrayList());
//         visited.add(num);
//         for(Node node : list){
//             dfs(node.val,delay+node.delay,n);
//         }
//     }
// }


class Solution {
    class Node {
        int val, delay;
        Node(int val, int delay) {
            this.val = val;
            this.delay = delay;
        }
    }

    Map<Integer, List<Node>> adjListMap = new HashMap<>();
    Map<Integer, Integer> minDelayMap = new HashMap<>();

    public int networkDelayTime(int[][] times, int n, int k) {
        for (int[] time : times) {
            int u = time[0], v = time[1], w = time[2];
            adjListMap.computeIfAbsent(u, x -> new ArrayList<>()).add(new Node(v, w));
        }

        dfs(k, 0);

        if (minDelayMap.size() != n) return -1;

        int maxDelay = 0;
        for (int time : minDelayMap.values()) {
            maxDelay = Math.max(maxDelay, time);
        }
        return maxDelay;
    }

    private void dfs(int node, int delay) {
        if (minDelayMap.containsKey(node) && delay >= minDelayMap.get(node)) {
            return;
        }
        minDelayMap.put(node, delay);

        if (!adjListMap.containsKey(node)) return;
        for (Node neighbor : adjListMap.get(node)) {
            dfs(neighbor.val, delay + neighbor.delay);
        }
    }
}



