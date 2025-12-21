class Solution {

    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> numCount = new HashMap<>();

        for(int n : nums) numCount.put(n, numCount.getOrDefault(n,0)+1);
        int count=0;
        for(Integer val : numCount.values()){
            if(val<2)continue;
            val-=1;
            int num = (val*(val+1))/2;
            count += num;
        }
        return count;
    }


}