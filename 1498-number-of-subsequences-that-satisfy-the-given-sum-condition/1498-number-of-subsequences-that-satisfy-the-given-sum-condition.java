class Solution {

    private static int[] powerOfTwo = new int[100000];
    static int mod = 1000000007;
    static{
        powerOfTwo[0] = 1;
        for(int i = 1; i < 100000; i++) {
            powerOfTwo[i] = (powerOfTwo[i - 1] * 2) % mod;
        }
    }

    public int numSubseq(int[] nums, int target) {

        Arrays.sort(nums);

        int len = nums.length;
        int left=0, right=len-1;
        int count = 0;

        int[] powerOfTwo = new int[len];
        powerOfTwo[0] = 1;
        for(int i = 1; i < len; i++) {
            powerOfTwo[i] = (powerOfTwo[i - 1] * 2) % mod;
        }

        while(left<=right){
           if(nums[left]+nums[right] <= target){
            count = (count+powerOfTwo[right-left])%mod;
            left++;
           }else{
            right--;
           }
        }

        return count;
        
    }
 
    // 1 [1] 1
    // 1,2 [1],[2],[1,2] [2,1] 4
    // 1,2,3 [1,2,3] [1,3,2] [2,1,3] [2,3,1] [3,1,2] [3,2,1] 6 + 4 + 2 + 1 = 11
    // 1,2,3,4 []
    
}




