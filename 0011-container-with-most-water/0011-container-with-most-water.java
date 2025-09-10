class Solution {
    public int maxArea(int[] height) {

        int i =0;
        int j = height.length-1;
        int maxArea = 0;
        while(i<j){
            int h = Math.min(height[i],height[j]);
            maxArea = Math.max(maxArea,(h*(j-i)));
            // if(height[i]>height[j])
            //     j--;
            // else i++;
            while(i<j && height[i]<=h)i++;
            while(i<j && height[j]<=h)j--;
        }
        return maxArea;
    }
}