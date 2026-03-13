class Solution {
    int[] dp;
    public int numDecodings(String s) {
        dp = new int[s.length()];
        Arrays.fill(dp,-1);
        return dfs(s,-1, 0);   
    }

    public int dfs(String s, int num, int i){
        if(num==0)return 0;
        if(i==s.length())return 1;
        if(dp[i]!=-1)return dp[i];
        char c1 = s.charAt(i);
        if(c1=='0')return 0;
        int oneDigitCount = dfs(s,Integer.parseInt(""+c1),i+1);
        int twoDigitCount = 0;
        if(i+1<s.length()){
            char c2 = s.charAt(i+1);
            int number = Integer.parseInt(""+c1+c2);
            if(number>=10 && number<=26)
                twoDigitCount = dfs(s,number,i+2);
        }
        return dp[i] = oneDigitCount + twoDigitCount;
    }   
}




