class Solution {
    boolean[][] visited;
    boolean isValid=true;
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        
        int n = grid1.length,m=grid1[0].length;
        visited = new boolean[n][m];
        int res = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                isValid=true;
                if(!visited[i][j] && grid2[i][j]==1 && grid1[i][j]==1){
                    isSubIsland(i,j,grid1,grid2);
                    if(isValid)res+=1;
                }
            }
        }
        return res;
    }

    public void isSubIsland(int i, int j, int[][] grid1, int[][] grid2){

        visited[i][j]=true;
        int[][] arr = {{0,1},{0,-1},{1,0},{-1,0}};
        int n = grid1.length,m=grid1[0].length;
        for(int[]ar : arr){
            int i1 = ar[0]+i;
            int j1 = ar[1]+j;
            if(i1>=0 && i1<n && j1>=0 && j1<m && !visited[i1][j1]){
                if(grid2[i1][j1]==1 && grid1[i1][j1]==0){
                    visited[i1][j1]=true;
                    isValid = false;
                }
                if(grid2[i1][j1]==1){
                    isSubIsland(i1,j1,grid1,grid2);
                }
            }   
        }
    }
}




   