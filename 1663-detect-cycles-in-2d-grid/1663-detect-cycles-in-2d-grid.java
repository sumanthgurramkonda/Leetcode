class Solution {
    boolean[][] visited;
    int n, m;
    public boolean containsCycle(char[][] grid) {
        n = grid.length;
        m = grid[0].length;
        visited = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j]){
                    if(dfs(grid,grid[i][j],i,j,-1,-1)) return true;
                }
            }
        }
        return false;
    }
    int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
    public boolean dfs(char[][] grid, char ch, int r, int c,int p1,int p2){
        if(visited[r][c])return true;
        visited[r][c] = true;
        for(int[] dir : directions){
            int row = r+dir[0];
            int col = c+dir[1];
            if(row<0 || row>=n || col<0 || col>=m || grid[row][col]!=ch || (row==p1 && col==p2)) continue;
            if(dfs(grid,ch,row,col,r,c)) return true;
        }
        return false;
    }
}