class Solution {
    public int largestRectangleArea(int[] heights) {
        
        int max = 0;
        // for(int i=0;i<heights.length;i++){
        //     int left =i-1,right=i+1;
        //     while(left>=0 && heights[left]>=heights[i])left--;
        //     while(right<heights.length && heights[right]>=heights[i])right++;
        //     int val = heights[i]*(right-left-1);
        //     max = Math.max(max, Math.max(heights[i],val));
        // }
        Stack<int[]> stack = new Stack();
        int maxArea = 0;
        for(int i=0;i<heights.length;i++){
            int start = i;
            while(!stack.isEmpty() && stack.peek()[1]>heights[i]){
                int[] arr = stack.pop();
                start = arr[0];
                maxArea = Math.max(maxArea,arr[1]*(i-start));
            }
            stack.push(new int[]{start,heights[i]});
        }
        while(!stack.isEmpty()){
            int[] arr = stack.pop();
            maxArea = Math.max(maxArea,arr[1]*(heights.length-arr[0]));
        }
        
        return maxArea;
    }
}

