class Solution {
    public int thirdMax(int[] nums) {
        int firstLarge = Integer.MIN_VALUE;
        int secondLarge = Integer.MIN_VALUE;
        int thirdLarge = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<>();
        int i = 0;
        for(int num : nums){
            if(set.contains(num))continue;
            nums[i++] = num;
            set.add(num);
        }
        int n = set.size();

        for(i=0;i<n;i++){
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
        if(n<3)return firstLarge;
        return thirdLarge;
    }
}