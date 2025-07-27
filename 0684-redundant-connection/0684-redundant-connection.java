class Solution {
    int[] parent;
    int[] ranks;
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n+1];
        ranks = new int[n+1];
        for(int i=0;i<n;i++)parent[i]=i;
        for(int[] edge : edges){
            if(!union(edge[0],edge[1])){
                return new int[]{edge[0],edge[1]};
            }
        }
        return new int[2];
    }

    public int find(int x){
        if(parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    public boolean union(int n1, int n2){
        n1 = find(n1);
        n2 = find(n2);
        if(n1==n2)return false;
        if(n1<n2){
            parent[n1]=n2;
        }else if(n1>n2){
            parent[n2]=n1;
        }else{
            parent[n2]=n1;
            parent[n1]++;
        }
        return true;
    }
}

