class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        int n = temperatures.length;
        int[] res = new int[n];
        // Stack<Integer> stack = new Stack<>();
        // stack.push(n-1);

        for(int i=n-2; i>=0; i--){
            int index = i+1;
            while(index<n && temperatures[i] >= temperatures[index]){
                if(res[index]==0) index=n;
                else{
                    index += res[index];
                }
            }
            if(index<n) res[i] = index-i;
            // while(!stack.isEmpty() && temperatures[stack.peek()]<=temperatures[i]){
            //     stack.pop();
            // }
            // if(!stack.isEmpty()) res[i] = stack.peek()-i;
            // stack.push(i);
        }
        return res;
    }
}