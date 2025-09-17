class Solution {
    public int minMoves2(int[] nums) {
        
        // int max = Integer.MIN_VALUE;
        // int min = Integer.MAX_VALUE;

        // for(int n : nums){
        //     max = Math.max(max,n);
        //     min = Math.min(min,n);
        // }
        // if(max==min)return 0;
        // int res = Integer.MAX_VALUE;
        // for(int i=min;i<=max;i++){
        //     int count = 0;
        //     for(int n : nums){
        //         count += Math.abs(n-i);
        //     }
        //     res = Math.min(res,count);
        // }
        // return res;
        Arrays.sort(nums);
        int operations = 0, mid = nums[nums.length/2];
        for (int num: nums) operations += Math.abs(mid - num);
        return operations;
    }
}