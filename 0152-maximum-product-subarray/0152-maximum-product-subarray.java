class Solution {

    public int maxProduct(int[] nums) {
        
        int res = Integer.MIN_VALUE;

        int maxProduct = 1, minProduct = 1;
        for(int num : nums){
            int temp1 = maxProduct*num;
            int temp2 = minProduct*num;
            maxProduct = Math.max(Math.max(temp1,temp2),num);
            minProduct = Math.min(Math.min(temp1,temp2),num);
            res = Math.max(res, maxProduct);
        }
        
        for(int num : nums) res = Math.max(res, num);
        return res;
    }
}