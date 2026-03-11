class Solution {

    boolean[][] visited;
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int n = grid1.length;
        int m = grid1[0].length;
        visited = new boolean[n][m];
        int count = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid2[i][j]==1 && !visited[i][j]){
                    countSubIslands(grid1,grid2,i,j);
                    if(isValidIsland)count++;
                    isValidIsland = true;
                }
            }
        }
        return count;
    }

    int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    boolean isValidIsland = true;
    public void countSubIslands(int[][] grid1, int[][] grid2, int i, int j) {
        // if(i<0 || i>=grid1.length || j<0 || j>=grid1[0].length) return;
        if(visited[i][j]) return;
        if(grid1[i][j]==0){
            isValidIsland=false;
        }
        visited[i][j]=true;
        for(int[] dir : directions){
            int r = i+dir[0];
            int c = j+dir[1];
            if(r<0 || r>=grid1.length || c<0 || c>=grid1[0].length || grid2[r][c]==0)continue;
            countSubIslands(grid1,grid2,r,c);
        }
    }


}