class MyQueue {

    Stack<Integer> stack = new Stack<>();
    
    public MyQueue() {
        
    }
    
    public void push(int x) {
        stack.push(x);
    }
    
    public int pop() {
        Stack<Integer> tempStack = new Stack<>();
        while(!stack.isEmpty()){
            tempStack.push(stack.pop());
        }
        int peekVal = tempStack.pop();
        while(!tempStack.isEmpty()){
            stack.push(tempStack.pop());
        }
        return peekVal;
    }
    
    public int peek() {
        Stack<Integer> tempStack = new Stack<>();
        while(!stack.isEmpty()){
            tempStack.push(stack.pop());
        }
        int peekVal = tempStack.peek();
        while(!tempStack.isEmpty()){
            stack.push(tempStack.pop());
        }
        return peekVal;
    }
    
    public boolean empty() {
        return stack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */