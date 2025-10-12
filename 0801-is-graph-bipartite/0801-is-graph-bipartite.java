class Solution {

    int[] color;
    public boolean isBipartite(int[][] graph) {
        color = new int[graph.length];
        boolean res = true;
        for(int i=0;i<graph.length;i++){
            if(color[i]==0)
                res = res && isBipartite(graph,i,1);
        }
        return res;
    }

    public boolean isBipartite(int[][] graph, int node,int col){
        if(col==1){
            if(color[node]==-1)return false;
            color[node]=col;
        }
        else{
            if(color[node]==1)return false;
            color[node]=col;
        }
        for(int n : graph[node]){
            if(color[n]==0 && !isBipartite(graph,n,-col))return false;
            else if(color[n]==col)return false;
        }

        return true;
    }

}


