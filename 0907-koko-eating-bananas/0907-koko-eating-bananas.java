class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Integer.MIN_VALUE;
        for(int n : piles){
            right = Math.max(right,n);
        }
        while(left<right){
            int mid = (left+right)/2;
            int h1 = 0;
            for (int n : piles){
                h1 += (n/mid);
                if(n%mid!=0)h1+=1;
            }
            if(h1<=h){
                right = mid;
            }else left = mid+1;
        }
        return left;
    }

}
