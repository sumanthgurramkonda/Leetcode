class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        Queue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((e1,e2)->{
            int v1 = e1.getValue();
            int v2 = e2.getValue();
            if(v1==v2)return 0;
            else if(v1>v2) return -1;
            else return 1;
            });   
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            queue.offer(entry);
        }
        int[] res = new int[k];
        for(int i=0;i<k;i++){
            res[i]= queue.poll().getKey();
        }
        return res;
    }
}




