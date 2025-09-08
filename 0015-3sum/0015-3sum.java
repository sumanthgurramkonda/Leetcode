class Solution {

    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList();
        for(int i=0;i<n-2;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            int l = i+1,r=n-1;
            while(l<r){
                int left = nums[l];
                int right = nums[r];
                int total = nums[i]+nums[l]+nums[r];
                if(total > 0){
                    r--;
                }else if( total < 0){
                    l++;
                }else{
                    res.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    l++;
                    while(nums[l]==nums[l-1] && l<r) l++;
                }
            }
        }
        return res;
    }

}




