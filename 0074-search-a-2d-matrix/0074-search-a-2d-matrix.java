class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int n = matrix.length;
        int m = matrix[0].length;
        int l=0;
        int r = m*n-1;
        while(l<=r){
            int mid = (l+r)/2;
            int row = mid/m;
            int col = mid%m;
            int num = matrix[row][col];
            if(num==target)return true;
            if(num<target){
                l=mid+1;
            }else r=mid-1;
        }
        return false;
    }
}