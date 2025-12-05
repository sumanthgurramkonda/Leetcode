class Solution {
    public boolean isHappy(int n) {

        HashSet<Integer> set = new HashSet<>();
        while(set.isEmpty() || !set.contains(n)){
            set.add(n);
            n = getNumber(n);
            if(n==1)return true;
        }
        return false;
    }

    public int getNumber(int n){
        int num=0;
        while(n>0){
            int digit = n % 10;
            num += digit * digit;  
            n /= 10;
        }
        return num;
    }
}