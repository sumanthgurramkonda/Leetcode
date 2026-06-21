class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((e1, e2)->Integer.compare(e1.getValue(), e2.getValue()));   
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(queue.size()==k){
                if(queue.peek().getValue()<entry.getValue()){
                    queue.poll();
                    queue.offer(entry);
                }
            }else{
                queue.offer(entry);
            }
            
        }
        int[] res = new int[k];
        for(int i=0;i<k;i++){
            res[i]= queue.poll().getKey();
        }
        return res;
    }
}




