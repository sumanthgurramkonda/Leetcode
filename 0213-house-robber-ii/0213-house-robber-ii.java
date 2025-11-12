class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n<=1)return nums[0];
       
        return Math.max(rob(nums,0,1,n-1),rob(nums,1,2,n));
    }
    public int rob(int nums[],int k,int m,int n){
        int prevRow = 0;
        int maxRow = nums[k];
        for(int i=m;i<n;i++){
            int temp = Math.max(prevRow+nums[i],maxRow);
            prevRow = maxRow;
            maxRow = temp; 
        }
        return Math.max(prevRow,maxRow);
    }

}