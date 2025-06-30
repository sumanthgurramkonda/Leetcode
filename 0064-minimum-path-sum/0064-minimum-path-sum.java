class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] memo = new int[n+1][m+1];
        for(int i=0;i<m;i++){
            memo[n][i]=Integer.MAX_VALUE;
        }
        for(int i=0;i<n;i++){
            memo[i][m]=Integer.MAX_VALUE;
        }
        memo[n-1][m]=0;
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                memo[i][j] = Math.min(memo[i][j+1], memo[i+1][j])+grid[i][j];
            }
        }
        return memo[0][0];
    }
}