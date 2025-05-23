class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int i=0, j=m-1;
        while(i>=0 && i<n && j>=0 && j<m){
            if(matrix[i][j]==target)return true;
            if(matrix[i][j]>target) j--;
            else i++;
        }
        return false;
    }
}