class Solution {
    boolean[] visited;
    Map<Integer, Integer> map = new HashMap<>();
    public int longestCycle(int[] edges) {
        int n = edges.length;
        visited = new boolean[n];
        for(int i=0;i<n;i++){
            dfs(edges, edges[i]);
            map.put(edges[i], res);
        }
        return res;
    }
    int visitedNode = -2;
    int res = -1;
    public int dfs(int[] edges, int node){
        if(map.containsKey(node))return map.get(node);
        if(node==-1)return -1;
        if(visited[node]){
            visitedNode = node;
            return 0;
        }
        visited[node]=true;
        int count = dfs(edges, edges[node]);
        visited[node]=false;
        map.put(node, count);
        if(count>=0){
            if(visitedNode==node){
                res = Math.max(res, count+1);
                return count;
            }
            return count+1;
        }
        return -1;
    }

}