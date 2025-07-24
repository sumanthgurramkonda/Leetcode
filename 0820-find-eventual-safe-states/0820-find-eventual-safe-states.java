class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        Boolean[] safeNode = new Boolean[graph.length];
        List<Integer> res = new ArrayList();
        for(int i=0;i<graph.length;i++){
            if(safeNode(graph,safeNode,i)){
                res.add(i);
            }
        }

        return res;
    }

    public boolean safeNode(int[][]graph,Boolean[]safeNode,int node){
        if(safeNode[node]!=null)return safeNode[node];
        safeNode[node]=false;
        for(int i=0;i<graph[node].length;i++){
            if(!safeNode(graph,safeNode,graph[node][i])) return false;
        }
        return safeNode[node]=true;
    }
}