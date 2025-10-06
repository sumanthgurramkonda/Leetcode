class KthLargest {

    PriorityQueue<Integer> minQueue;
    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        minQueue = new PriorityQueue<>();
        for(int n : nums){
            if(minQueue.size()==k){
                if(n>minQueue.peek()){
                    minQueue.poll();
                    minQueue.add(n);
                }
            }else{
                minQueue.add(n);
            }
            
        }
    }
    
    public int add(int val) {
        if(minQueue.size()<k){
            minQueue.add(val);
        }
        else if(val>minQueue.peek()){
            minQueue.poll();
            minQueue.add(val);
        }
        return minQueue.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */