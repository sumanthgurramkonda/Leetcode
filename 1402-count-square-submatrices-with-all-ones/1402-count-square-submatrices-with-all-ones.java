class Solution {
    public int countSquares(int[][] matrix) {
         int n = matrix.length;
         int m = matrix[0].length;

         int[][] dp = new int[n][m];

         for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j] = matrix[i][j];
            }
         }

         for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(dp[i][j]!=0){
                    dp[i][j] = 1+Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]));
                }
            }
         }
         int res = 0;
         for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                res += dp[i][j];
            }
         }
         return res;
    }
}




