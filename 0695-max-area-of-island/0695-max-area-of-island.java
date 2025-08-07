class Solution {
    boolean[][] visited;
    public int maxAreaOfIsland(int[][] grid) {
        visited = new boolean[grid.length][grid[0].length];
        int res=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(!visited[i][j]){
                    res = Math.max(res,maxArea(i,j,grid));
                }
            }
        }
        return res;
    }

    public int maxArea(int i,int j, int[][]grid){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || visited[i][j] || grid[i][j]==0)return 0;
        int[][] traverse = {{0,1},{0,-1},{1,0},{-1,0}};
        int islandArea = 1;
        visited[i][j]=true;
        for(int[] index : traverse){
            int row = i+index[0];
            int col = j+index[1];
            islandArea+=maxArea(row,col,grid);
        }
        return islandArea;
    }
}