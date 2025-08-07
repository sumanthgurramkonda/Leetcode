class Solution {
    int[][] costs;
    int[][] memo;
    Map<Integer, List<Integer>> adjListMap = new HashMap();
    Set<Integer> visited = new HashSet();
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        costs = new int[n][n];
        memo = new int[n][k + 2];
        for(int[] arr : memo) Arrays.fill(arr,-1);
        for(int i=0;i<flights.length;i++){
            int v1 = flights[i][0];
            int v2 = flights[i][1];
            costs[v1][v2]=flights[i][2];
            adjListMap.putIfAbsent(v1,new ArrayList());
            adjListMap.get(v1).add(v2);
        }
        int res = findCheapestPrice(src,dst,k+1);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public int findCheapestPrice(int src,int dest,int k){
        if(k==-1)return Integer.MAX_VALUE;
        if(dest==src){
            return 0;
        }
        if(memo[src][k]!=-1)return memo[src][k];
        visited.add(src);
        int minCost = Integer.MAX_VALUE;
        for(Integer v : adjListMap.getOrDefault(src,new ArrayList<>())){
            int subCost = findCheapestPrice(v, dest, k - 1);
            if (subCost != Integer.MAX_VALUE) {
                minCost = Math.min(minCost, subCost + costs[src][v]);
            }
        }
        visited.remove(src);
        return memo[src][k]=minCost;
    }
}




