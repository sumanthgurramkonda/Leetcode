class Solution {

//     public int maxCoins(int[] nums) {
//         // List<Integer> list = new ArrayList();
//         // for(int n :nums)list.add(n);
//         // return maxCoins(list);
//         int n = nums.length;
//         int[] nums1 = new int[n+2];
//         nums1[0]=1;
//         nums1[n+1]=1;
//         for(int i=1;i<=n;i++)nums1[i]=nums[i-1];
//         int[][] dp = new int[n+2][n+2];
//         return maxCoins(nums1,1,n+1,dp);
//     }

//     public int maxCoins(int[] nums, int left,int right,int[][]dp){
//         if(left+1 == right) return 0;
//         if(dp[left][right]>0)return dp[left][right];
//         int ans = 0;
//         for(int i=left+1;i<right;i++){
//             ans = Math.max(ans, nums[left]*nums[i]*nums[right] +
//                                  maxCoins(nums,left,i,dp) + maxCoins(nums,i,right,dp));
//         }
//         dp[left][right]=ans;
//         return ans;
//     }

//     public int maxCoins(List<Integer> list){
//         int max = 0;
//         for(int i=0;i<list.size();i++){
//             int left = i == 0 ? 1 : list.get(i-1);
//             int right = i==list.size()-1 ? 1 : list.get(i+1);
//             int coins = left*right*list.get(i);
//             List<Integer> newList = new ArrayList(list);
//             newList.remove(i);
//             coins += maxCoins(newList);
//             max = Math.max(max,coins);
//         }
//         return max;
//     }
    public int maxCoins(int[] iNums) {
        int[] nums = new int[iNums.length + 2];
        int n = 1;
        for (int x : iNums) if (x > 0) nums[n++] = x;
        nums[0] = nums[n++] = 1;


        int[][] memo = new int[n][n];
        return burst(memo, nums, 0, n - 1);
    }

    public int burst(int[][] memo, int[] nums, int left, int right) {
        if (left + 1 == right) return 0;
        if (memo[left][right] > 0) return memo[left][right];
        int ans = 0;
        for (int i = left + 1; i < right; ++i)
            ans = Math.max(ans, nums[left] * nums[i] * nums[right] 
            + burst(memo, nums, left, i) + burst(memo, nums, i, right));
        memo[left][right] = ans;
        return ans;
    }

}



