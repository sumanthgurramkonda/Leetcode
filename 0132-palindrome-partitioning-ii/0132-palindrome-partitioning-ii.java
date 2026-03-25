class Solution {
    
    int[] memo;
    public int minCut(String s) {
        memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return partitions(s, 0)-1;
    }

    public int partitions(String s, int index){
        if(index>=s.length()){
            return 0;
        }
        int minLen = Integer.MAX_VALUE;
        if(memo[index]!=-1)return memo[index];
        for(int j=index;j<s.length();j++){
            if(isPalinDrome(s,index,j)){
                minLen = Math.min(minLen, partitions(s,j+1));
            }
        }
        return memo[index] = minLen==Integer.MAX_VALUE ? minLen : minLen+1;
    }

    public boolean isPalinDrome(String s, int l ,int r){
        while(l<r){
            if(s.charAt(l)!=s.charAt(r))return false;
            l++;
            r--;
        }
        return true;
    }
}




