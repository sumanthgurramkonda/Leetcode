class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums.length==1)return nums[0];
        Map<Integer, Integer> map = new HashMap();
        for(int n : nums){
            if(!map.containsKey(n)){
                map.put(n,1);
            }else{
                map.put(n,map.get(n)+1);
            }
        }
        Arrays.sort(nums);
        List<Integer> list = new ArrayList();
        Set<Integer> set = new LinkedHashSet();
        int n = nums.length;
        for(int i=0;i<n;i++)set.add(nums[i]);
        for(Integer num : set)list.add(num);
        
        int prevEarn=0;
        int earn = nums[0]*map.get(nums[0]);

        for(int i=1;i<list.size();i++){
            int num1 = list.get(i);
            int num2 = list.get(i-1);
            int currentEarn = num1*map.get(num1);
            System.out.println(prevEarn+" "+earn);
            if(num1-1==num2){
                currentEarn += prevEarn;
                
            }else{
                currentEarn += Math.max(earn, prevEarn);
            }
            prevEarn = Math.max(earn, prevEarn);;
            earn = currentEarn;
        }
        return Math.max(earn, prevEarn);
    }
}



