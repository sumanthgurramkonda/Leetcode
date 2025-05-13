class Solution {
    public int numDistinct(String s, String t) {
        int dp[][] = new int[s.length()][t.length()];
        for(int[] arr : dp)Arrays.fill(arr,-1);
        return distinctSubSequences(s,t,0,0,dp);
    }

    public int distinctSubSequences(String s, String t, int i, int j, int dp[][]){
        if(j>=t.length()) return 1;
        if(i>=s.length())return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        if(s.charAt(i)==t.charAt(j)){
            int count1 = 0;
            count1 += distinctSubSequences(s,t,i+1,j+1,dp);
            int count2 = 0;
            count2 += distinctSubSequences(s,t,i+1,j,dp);
            dp[i][j] = count1 + count2;
        }
        else {
            int count = 0;
            count += distinctSubSequences(s,t,i+1,j,dp);
            dp[i][j]=count;
        }
        return dp[i][j];
    }
}



