class Solution {

    int dp[];
    public int longestStrChain(String[] words) {
        
        Arrays.sort(words,(w1,w2)->w1.length()-w2.length());
        dp = new int[words.length];
        Arrays.fill(dp,-1);

        int maxChain = 1;
        for (int i = 0; i < words.length; i++) {
            maxChain = Math.max(maxChain, dfs(words, i));
        }
        return maxChain;
    }

    public int dfs(String[] words, int index){
        if(dp[index]!=-1)return dp[index];
        int best = 1;
        for(int i=index+1;i<words.length;i++){
            if(isValidSequence(words[index],words[i])){
                best = Math.max(best,dfs(words,i)+1);
            }
        }
        return dp[index]=best;
    }

    private boolean isValidSequence(String shorter, String longer) {
        if (shorter.length() + 1 != longer.length()) return false;

        int i = 0, j = 0;
        while (i < shorter.length() && j < longer.length()) {
            if (shorter.charAt(i) == longer.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == shorter.length();
    }
}




