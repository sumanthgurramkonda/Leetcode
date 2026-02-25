class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        int sum=0, res=Integer.MAX_VALUE;
        int l = 0;
        for(int r=0;r<nums.length;r++){
            sum += nums[r];
            while(l<r && sum-nums[l]>=target){
                sum -= nums[l];
                l++;
            }
            if(sum>=target) res = Math.min(res, r-l+1);
        }
        return res==Integer.MAX_VALUE ? 0 : res;
    }
}


/*
sum target res
 i = 0 to n-1;
    j=i to n-1
      sum += nums[j];
      if(sum>=target) res = Math.min(res, j-i+1);
*/

/*       l r
[2,3,1,2,4,3]
2 5 6 8 6 7 7

res = 2

*/