class Solution {
    int[] nodes;
    int[] size;
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        nodes = new int[n+1];
        size = new int[n+1];
        for(int i=1;i<=n;i++){
            nodes[i] = i;
            size[i] = 1;
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

        if(size[nodeX]<=size[nodeY]){
            nodes[nodeX] = nodeY;
            size[nodeX]++;
        }else{
            nodes[nodeY] = nodeX;
            size[nodeY]++;
        }

        return true;
    }

}