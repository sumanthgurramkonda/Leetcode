class Solution {
    public int longestValidParentheses(String s) {

        int left = 0, right=0;
        int maxLen=0;
        Stack<Integer> stack = new Stack();
        stack.push(-1);
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.push(i);
            }else{
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }else{
                    maxLen = Math.max(maxLen, i-stack.peek());
                }
            }
        }
        return maxLen;
    }
}