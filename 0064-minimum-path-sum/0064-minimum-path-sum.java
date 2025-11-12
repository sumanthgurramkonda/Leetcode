class Solution {
    int[][] dp;
    public int minPathSum(int[][] grid) {
        dp = new int[grid.length][grid[0].length];
        for(int[] arr : dp)Arrays.fill(arr,-1);
        return dfs(grid, 0,0);
    }

    public int dfs(int[][] grid, int r, int c){
        if(r==grid.length-1 && c==grid[0].length-1)return grid[r][c];
        if(r>=grid.length || c>=grid[0].length)return Integer.MAX_VALUE;
        if(dp[r][c]!=-1)return dp[r][c];
        int right = dfs(grid, r,c+1);
        int down = dfs(grid, r+1, c);
        int min = Math.min(right,down);
        if(min==Integer.MAX_VALUE)return dp[r][c]=Integer.MAX_VALUE;
        return dp[r][c] = grid[r][c]+min;
    }
}