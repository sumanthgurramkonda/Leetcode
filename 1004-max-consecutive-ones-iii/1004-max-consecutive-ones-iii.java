class Solution {
    public int longestOnes(int[] nums, int k) {

        int zeroCount=0, res = 0;
        int l=0;

        for(int r=0;r<nums.length;r++){
            if(nums[r]==0)zeroCount++;
            while(l<=r && zeroCount>k){
                if(nums[l]==0)zeroCount--;
                l++;
            }
            res = Math.max(res, r-l+1);
        }
        return res;
    }
}

/*



*/

/*

3 4 5 10   k = 2

3 4 ; 3 5 ; 3 10
4 5 ; 4 10
5 10
n * m

*/