class Solution {
    public String decodeString(String s) {

        Stack<Character> stack = new Stack();

        for(char c : s.toCharArray()){
            if(c!=']'){
                stack.push(c);
            }else{
                String str ="";
                while(stack.peek()!='['){
                    str = stack.pop() + str;
                }
                stack.pop();
                String num = "";
                while(!stack.isEmpty() && stack.peek()>='0' && stack.peek()<='9'){
                    num = stack.pop()+num;
                }
                int n = Integer.parseInt(num);
                String str1 = "";
                for(int i=0;i<n;i++){
                    str1 += str;
                }
                for(char c1 : str1.toCharArray())stack.push(c1);
            }
        }
        String res="";
        while(!stack.isEmpty()){
            res = stack.pop()+res;
        }
        return res;
    }
    
}




