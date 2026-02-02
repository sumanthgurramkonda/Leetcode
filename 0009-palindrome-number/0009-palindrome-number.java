class Solution {
    public boolean isPalindrome(int x) {
        if(x<0)return false;
        int temp = x;
        int num=0;
        int rem;
        while(x>0){
            rem = x%10;
            num = num*10+rem;
            x /=10;
        }
        return temp==num;
    }
}