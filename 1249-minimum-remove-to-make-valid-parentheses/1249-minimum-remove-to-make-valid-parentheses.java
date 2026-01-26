class Solution {
    public String minRemoveToMakeValid(String s) {


        int len = s.length();
        Stack<Integer> stack = new Stack<>();
        Set<Integer> set = new HashSet<>();

        for(int i=0;i<len; i++){
            char c = s.charAt(i);
            if(c=='(' || c==')'){
                if(!stack.isEmpty()){
                    if(c=='('){
                        stack.push(i);
                    }else{
                        stack.pop();
                    }
                }else{
                    if(c=='('){
                        stack.push(i);
                    }else{
                        set.add(i);
                    };
                }
            }
        }

        while(!stack.isEmpty()) set.add(stack.pop());

        StringBuilder res = new StringBuilder();
        for(int i=0;i<len;i++) if(!set.contains(i)) res.append(s.charAt(i));
        return res.toString();
    }
}

