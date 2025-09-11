class Solution {
    public int findMaxLength(int[] nums) {
        
        int n = nums.length;
        if(n==1 || n==0)return 0;
        
        Map<Integer, Integer> map = new HashMap();
        map.put(0,-1);
        int res = 0;
        int sum = 0;
        for(int i=0;i<n;i++){
            sum += nums[i]==0 ? -1 : 1;
            if(map.containsKey(sum)){
                res = Math.max(res,i-map.get(sum));
            }else{
                map.put(sum,i);
            }
        }
        return res;
    }
}


