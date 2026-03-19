class Solution {
    Boolean[][] memo;
    public boolean isMatch(String s, String p) {
        memo = new Boolean[s.length()+1][p.length()+1];
        return dfs(s,p,0,0);
    }

    public boolean dfs(String s, String p, int i, int j){
        if(i==s.length() && j==p.length())return true;
        if(j==p.length())return false;
        if(s.length()==i){
            if(p.charAt(j)=='*'){
                return dfs(s,p,i,j+1);
            }
            return false;
        }
        if(memo[i][j]!=null)return memo[i][j];
        char c1 = s.charAt(i);
        char c2 = p.charAt(j);
        boolean isValid = false;
        if(c1==c2 || c2=='?'){
            isValid = dfs(s,p,i+1,j+1);
        }else if(c2=='*'){
            isValid = dfs(s,p,i+1,j) ||  dfs(s,p,i,j+1) || dfs(s,p,i+1,j+1);
        }
        return memo[i][j]=isValid;
    }
}