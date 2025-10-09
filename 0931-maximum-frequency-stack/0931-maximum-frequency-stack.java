class FreqStack {

    Map<Integer, Stack<Integer>> stackMap = new HashMap<>();
    Map<Integer, Integer> freqMap = new HashMap<>();
    int maxFreq = 0;
    public FreqStack() {
    }
    
    public void push(int val) {
        int freq = freqMap.getOrDefault(val, 0);
        freqMap.put(val,freq+1);
        stackMap.computeIfAbsent(freq+1,f->new Stack<>()).add(val);
        maxFreq = Math.max(freq+1,maxFreq);
    }
    
    public int pop() {
        Stack<Integer> stack = stackMap.get(maxFreq);
        int res = stack.pop();
        freqMap.put(res,maxFreq-1);
        if(stack.isEmpty()){
            stackMap.remove(maxFreq);
            maxFreq--;
        }
        return res;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */