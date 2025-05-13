class Solution {
    public int combinationSum4(int[] nums, int target) {
        return combinationSum(nums,target,new HashMap());
    }

    public int combinationSum(int[] nums, int target,Map<Integer, Integer> map){
        if(target==0)return 1;
        if(target<0)return 0;
        int sum = 0;
        if(map.containsKey(target))return map.get(target);
        for(int i=0;i<nums.length;i++){
            sum += combinationSum(nums,target-nums[i],map);
        }
        map.put(target,sum);
        return sum;
    }
}




  