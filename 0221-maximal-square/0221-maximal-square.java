class Solution {
    public int maximalSquare(char[][] matrix) {

        int maxLen = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] arr = new int[n][m];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                arr[i][j] = matrix[i][j]=='0' ? 0 : 1;
                maxLen = Math.max(maxLen, arr[i][j]);
            }
        }
        
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(arr[i][j]==1)
                    arr[i][j] += Math.min(arr[i-1][j-1], Math.min(arr[i][j-1],arr[i-1][j]));
                maxLen = Math.max(maxLen, arr[i][j]);
            }
        }
        return maxLen*maxLen;
    }
}