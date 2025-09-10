class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        // for(int i=0;i<nums.length;i++){
        //     int sum = 0;
        //     for(int j=i;j<nums.length;j++){
        //         sum +=nums[j];
        //         if(sum==k){
        //             count++;
        //         }
        //     }
        // }
        // for(int i=1;i<nums.length;i++){
        //     nums[i]=nums[i]+nums[i-1];
        // }
        Map<Integer, Integer> map = new HashMap();
        // map.put(0,1);
        // map.put(nums[0],1);
        int currentSum = 0;
        for(int i=1;i<nums.length;i++){
            nums[i] += nums[i-1];
        }
        for(int i=0;i<nums.length;i++){
            int ele = nums[i];
            int dif = nums[i]-k;
            if(map.containsKey(dif)){
                count += map.get(dif);
            }
            if(ele==k){
                count+=1;
            }
            if(map.containsKey(ele)){
                map.put(ele,map.get(ele)+1);
            }else map.put(ele,1);
        }
        return count;
    }
}