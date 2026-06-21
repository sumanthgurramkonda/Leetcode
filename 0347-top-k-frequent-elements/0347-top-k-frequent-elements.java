class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums) map.put(num, map.getOrDefault(num,0)+1);
        int n = nums.length;
        List[] bucket = new List[n+1];

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(bucket[entry.getValue()]==null){
                bucket[entry.getValue()] = new ArrayList<Integer>();
            }
            bucket[entry.getValue()].add(entry.getKey());
        }
        int[] res = new int[k];
        int index = 0;
        for(int i=n;i>=0 && index<k; i--){
            if(bucket[i]==null)continue;
            for(Object num : bucket[i]){
                res[index++] = (int)num;
            }
        }
        return res;
    }
}