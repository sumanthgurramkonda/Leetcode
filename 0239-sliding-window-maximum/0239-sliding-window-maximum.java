class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if(n==1)return nums;
        int[] res = new int[n-k+1];
        // Queue<Integer> queue = new PriorityQueue<>((a,b)->b-a);
        // for(int i=0;i<k;i++){
        //     queue.add(nums[i]);
        // }
        // res[0] = queue.peek();
        // queue.remove(nums[0]);
        // for(int i=k;i<n;i++){
        //     res[i-k+1] = Math.max(nums[i], queue.isEmpty() ? Integer.MIN_VALUE : queue.peek());
        //     queue.remove(nums[i-k+1]);
        //     queue.add(nums[i]);
        // }

        Deque<Integer> deque = new LinkedList();

        for(int i=0;i<nums.length;i++){
            int num = nums[i];
            while(!deque.isEmpty() && deque.getLast()<num){
                deque.pollLast();
            }
            deque.addLast(num);
            if(i>=k && nums[i-k]==deque.getFirst()){
                deque.pollFirst();
            }
            if(i>=k-1){
                res[i-k+1] = deque.getFirst();
            }
        }
        
        return res;
    }
}