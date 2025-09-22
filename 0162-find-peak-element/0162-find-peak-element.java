class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if(n==1)return 0;
        int [] nums1 = new int[n+2];
        nums1[0] = Integer.MIN_VALUE;
        nums1[n+1] = Integer.MIN_VALUE;
        int index = 1;
        for(int i=0;i<n;i++) nums1[i+1] = nums[i];
        while(index <= n){
            if(nums1[index] > nums1[index+1]) return index-1;
            else index = index+1;
        }
        return -1;   
    }
}