class Solution {
    
    public int numIslands(char[][] grid) {
        int islandCount = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    dfs(grid,i,j);
                    islandCount++;
                }
            }
        }
        return islandCount;
    }

    public void dfs(char[][] grid, int r, int c){
        if(c<0 || c>=grid[0].length || r<0 || r>=grid.length || grid[r][c]!='1') return;
        grid[r][c]='2';
        dfs(grid,r-1,c);
        dfs(grid,r+1,c);
        dfs(grid,r,c-1);
        dfs(grid,r,c+1);
    }

}