class Solution {
    List<List<int[]>> adjList = new ArrayList<>();
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] flight : flights){
            int p = flight[0];
            int c = flight[1];
            int cost = flight[2];
            if(c!=src)
                adjList.get(p).add(new int[]{c,cost});
        }
        int[] costs = new int[n];
        Arrays.fill(costs,Integer.MAX_VALUE);
        costs[src]=0;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{src,0});

        while(k>=0){
            int size = queue.size();
            for(int i=0;i<size;i++){
                int[] parent = queue.poll();
                for(int[] child: adjList.get(parent[0])){
                    int childNode = child[0];
                    if(costs[childNode]<=parent[1]+child[1])continue;
                    costs[childNode] = parent[1]+child[1];
                    queue.add(new int[]{childNode,costs[childNode]});
                }
            }
            k--;
        }
        return costs[dst]==Integer.MAX_VALUE ? -1 : costs[dst];
    }
}