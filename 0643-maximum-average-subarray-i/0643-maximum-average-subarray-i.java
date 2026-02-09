class Solution {
    public double findMaxAverage(int[] nums, int k) {

        double maxAvg = 0d;
        double sum = 0d;
        for(int i=0;i<k;i++){
            sum += nums[i];
        }
        maxAvg = sum/k;

        for(int i=k;i<nums.length;i++){
            sum -= nums[i-k];
            sum += nums[i];
            maxAvg = Math.max(maxAvg, (sum/k));
        }
        return maxAvg;
    }
}