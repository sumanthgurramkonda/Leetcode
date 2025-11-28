class Solution {
    
    public int numDecodings(String s) {
        if(s.charAt(0)=='0') return 0;
        int[] dp = new int[s.length()];
        Arrays.fill(dp,-1);
        return numDecoding(s.toCharArray(), 1, 0,dp);
    }

    public int numDecoding(char[] s, int num, int i,int[] dp){
        if(num==0)return 0;
        if(i>=s.length){
            if(num>=1 && num<=26) return 1;
            return 0;
        }
        if(dp[i]!=-1)return dp[i];
        num = s[i]-'0';
        int counter1 = numDecoding(s,num,i+1,dp);
        int counter2 = 0;
        if(i<=s.length-2){
            num = s[i]-'0';
            num*=10;
            num+=(s[i+1]-'0');
            if(num>=10 && num<=26)counter2 = numDecoding(s,num,i+2,dp);
        }
        return dp[i] = counter1+counter2;
    }
}





