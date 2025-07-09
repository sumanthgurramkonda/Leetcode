class Solution {
    public int countSubstrings(String s) {

        char[] c = s.toCharArray();
        int res = 0;
        for(int i=0;i<c.length;i++){
            res += (countPalimdrome(c,i,i) + countPalimdrome(c,i,i+1));
        }
        return res;
        
    }

    public int countPalimdrome(char[] c,int l, int r){
        int res = 0;
        while(l>=0 && r<c.length && c[l]==c[r]){
                res+=1;
                l--;
                r++;
        }
        return res;
    }



}