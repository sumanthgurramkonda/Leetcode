class Solution {
    public int thirdMax(int[] nums) {
        long firstLarge = Long.MIN_VALUE;
        long secondLarge = Long.MIN_VALUE;
        long thirdLarge = Long.MIN_VALUE;

        for(int i=0;i<nums.length;i++){
            if(nums[i]==firstLarge || nums[i]==secondLarge || nums[i]==thirdLarge)continue;
            if(nums[i]>firstLarge){
                thirdLarge = secondLarge;
                secondLarge = firstLarge;
                firstLarge = nums[i];
            }else if(nums[i]>secondLarge){
                thirdLarge = secondLarge;
                secondLarge = nums[i];
            }else if(nums[i]>thirdLarge){
                thirdLarge = nums[i];
            }
        }
        return thirdLarge==Long.MIN_VALUE ? (int)firstLarge : (int)thirdLarge;
    }
}