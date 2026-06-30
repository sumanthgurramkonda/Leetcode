class Solution {
    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();

        for(String token : tokens){

            if(isOperator(token)){
                int num1 = stack.pop();
                int num2 = stack.pop();
                int res = doMath(num1,num2,token);
                stack.push(res);
            }else{
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    public int doMath(int num1, int num2, String operator){
        switch(operator){
            case "+" : return num1+num2;
            case "-" : return num2-num1;
            case "*" : return num2*num1;
            case "/" : return num2/num1;
            default : return 0;
        }
    }

    public boolean isOperator(String token){

        switch(token){
            case "+" : return true;
            case "-" : return true;
            case "*" : return true;
            case "/" : return true;
            default : return false;
        }
    }
}