class Solution {
    public long maximumScore(int[] nums) {

        //prefix sum
        long[] pArray = new long[nums.length];
        pArray[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            pArray[i] = nums[i]+pArray[i-1];
        }

        int min = nums[nums.length-1];
        long res = Integer.MIN_VALUE;

        for(int i=nums.length-2;i>=0;i--){
            res = Math.max(res, pArray[i]-min);
            min = Math.min(min, nums[i]);
        }

        return res;
    }
}