class Solution {
    int[] nodes ;
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        nodes = new int[n+1];
        for(int i=1;i<=n;i++){
            nodes[i] = i;
        }
        for(int[] node : edges){
            if(!union(node[0], node[1])){
                return new int[]{node[0], node[1]};
            }
        }
        return new int[]{-1,-1};
    }


    public int find(int n){
        if(nodes[n]!=n){
            nodes[n]=find(nodes[n]);
        }
        return nodes[n];
    }

    public boolean union(int x, int y){

        int nodeX = find(x);
        int nodeY = find(y);

        if(nodeX==nodeY) return false;

        if(nodes[nodeX]<=nodes[nodeY]){
            nodes[nodeX] = nodes[nodeY];
        }else{
            nodes[nodeY] = nodes[nodeX];
        }

        return true;
    }

}