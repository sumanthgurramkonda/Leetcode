class Solution {

    int[] nums;
    int[] rank;
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        rank = new int[n];
        nums = new int[n];
        for(int i=0;i<n;i++) nums[i] = i;

        for(int[] edge : edges){
            if(!union(edge[0]-1, edge[1]-1)) return edge;
        }
        return null;
    }

    public int find(int x){
        if(nums[x]==x)return x;
        return nums[x] = find(nums[x]);
    }


    public boolean union(int u, int v){

        int x = find(u);
        int y = find(v);
        if(x==y) return false;
        if(rank[x]<rank[y]){
            nums[x] = y;
        }else if(rank[x]>rank[y]){
            nums[x] = y;
        }else{
            nums[y] = x;
            rank[x]++;
        }
        return true;
    }
}