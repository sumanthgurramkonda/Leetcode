class Solution {
    int[][] dp;
    int n,m;
    public int longestIncreasingPath(int[][] matrix) {
        n = matrix.length;
        m = matrix[0].length;
        dp = new int[n][m];
        int result = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                result = Math.max(result,longestIncreasingPath(matrix,i,j));
            }
        }
        return result;
    }

    public int longestIncreasingPath(int[][] matrix, int i ,int j){
        if(i>=n || j>=m)return 0;
        if(dp[i][j]!=0)return dp[i][j];
        int left = 0;
        int right = 0;
        int top = 0;
        int down = 0;
        if(j-1>=0 && matrix[i][j] > matrix[i][j-1]){ 
           left = longestIncreasingPath(matrix,i,j-1);
        }
        if(j+1<m && matrix[i][j] > matrix[i][j+1]){ 
           right = longestIncreasingPath(matrix,i,j+1);
        }
        if(i-1>=0 && matrix[i][j] > matrix[i-1][j]){ 
           top = longestIncreasingPath(matrix,i-1,j);
        }
        if(i+1<n && matrix[i][j] > matrix[i+1][j]){ 
           down = longestIncreasingPath(matrix,i+1,j);
        }
        return dp[i][j] = Math.max(left,Math.max(right,Math.max(top,down)))+1;
    }
}