class Solution {
    public int reverse(int x) {
        
        long num=0;
        boolean isNegative = x<0;
        if(isNegative) x *=-1;
        while(x>0){
            num = num*10 + x%10;
            x /= 10;
        }

        if(num>Integer.MAX_VALUE)return 0;
        int res = (int)num;
        if(isNegative) return -res;
        return res;

    }
}