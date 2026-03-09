class Solution {

    Map<Integer, List<int[]>> adjMap = new HashMap<>();

    public int networkDelayTime(int[][] times, int n, int k) {
        
        for(int[] time : times){
            int node = time[0];
            int child = time[1];
            int t = time[2];
            if(!adjMap.containsKey(node)) adjMap.put(node,new ArrayList<>());
            adjMap.get(node).add(new int[]{child,t});
        }

        return bfs(k,n);

    }

    public int bfs(int k, int n){

        int[] dp = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        PriorityQueue<int[]> queue = new PriorityQueue<>((t1,t2)->t1[1]-t2[1]);
        queue.add(new int[]{k, 0});
        dp[k]=0;
        int maxTime = 0;
        while(!queue.isEmpty()){
            int[] node = queue.poll();
            if(node[1]>dp[node[0]])continue;
            for(int[] time : adjMap.getOrDefault(node[0], new ArrayList<>())){
                if(dp[time[0]]>node[1]+time[1]){
                    dp[time[0]] = node[1]+time[1];
                    queue.add(new int[]{time[0], node[1]+time[1]});
                }
            }
        }
        dp[0]=0;
        for(int num : dp) {
            if(num==Integer.MAX_VALUE)return -1;
            maxTime = Math.max(maxTime,num);
            System.out.println(num);
        }
        return maxTime;
    }

    
}