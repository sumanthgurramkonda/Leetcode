class Solution {
    public int firstMissingPositive(int[] nums) {

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i] - 1]) {
                // Swap nums[i] with nums[nums[i] - 1]
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
        }
        for(int i=1;i<=n;i++){
            if(nums[i-1]!=i)return i;
        }
        return n+1;
        
    }
}



