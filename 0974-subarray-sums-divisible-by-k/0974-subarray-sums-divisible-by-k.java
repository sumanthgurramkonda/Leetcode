class Solution {
    
    public int subarraysDivByK(int[] nums, int k) {

        // for(int i=0;i<nums.length;i++){
        //     int sum = 0;
        //     for(int j=i;j<nums.length;j++){
        //         sum += nums[j];
        //         if(sum%k==0)count++;
        //     }
        // }
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int count=0;
        int prefixSum = 0;

        for(int i=0;i<n;i++){
             prefixSum += nums[i];
             int mod = ((prefixSum % k)+k) % k;
             if(map.containsKey(mod)){
                count += map.get(mod);
             }
             map.put(mod,map.getOrDefault(mod,0)+1);
        }

        return count;

    }
}


