class Solution {
    public String longestPalindrome(String s) {
        
        String res = "";
        for(int i=0;i<s.length();i++){
            String p = palimdoneLength(s,i,i);
            if(p.length()>res.length()) res = p;
            p = palimdoneLength(s,i,i+1);
            if(p.length()>res.length()) res = p;
        }
        return res;
    }

    private String palimdoneLength(String s, int i,int j){
        int n = s.length();
        while(i>=0 && j<n){
            if(s.charAt(i)!=s.charAt(j)) return s.substring(i+1,j);
            i--;
            j++;
        }
        i++;
        return s.substring(i,j);
    }
}