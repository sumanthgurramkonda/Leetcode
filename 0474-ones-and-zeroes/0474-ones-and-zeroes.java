class Solution {

    class Pair{
        int index;
        int m;
        int n;
        public Pair(){

        }
        public Pair(int index, int m, int n){
            this.index = index;
            this.m = m;
            this.n = n;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair p = (Pair) o;
            return (this.index == p.index && this.m ==p.m && this.n == p.n);
        }

        @Override
        public int hashCode() {
            return Objects.hash(index,m,n);
        }

    }

    // Map<Pair, Integer> countMemo = new HashMap();
    int[][][] dp;
    public int findMaxForm(String[] strs, int m, int n) {
        int strsLen = strs.length;
        int[][] counts = new int[strsLen][2];
        for(int i = 0;i<strs.length;i++){
            counts[i] = countOnesAndZeros(strs[i]);
        }
        dp = new int[strsLen][m+1][n+1];
        for(int[][] arr : dp){
            for(int[] ar : arr){
                Arrays.fill(ar,-1);
            }
        }
        int res = dfs(counts,0,m,n);
        return res;
    }

    public int[] countOnesAndZeros(String str){
        int[] count = new int[2];
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='0')count[0]++;
            else count[1]++;
        }
        return count;
    }

    public int dfs(int[][] counts,int index, int m, int n){
        // if(m==0 && n==0)return 1;
        if(index>=counts.length)return 0;
        // Pair pair = new Pair(index, m,n);
        // if(countMemo.containsKey(pair)) return countMemo.get(pair);
        if(dp[index][m][n]!=-1)return dp[index][m][n];
        int m1 = m-counts[index][0];
        int n1 = n-counts[index][1];
        int count1 = 0, count2 = 0;
        if(m1>=0 && n1>=0){
            count1 = dfs(counts,index+1,m1,n1)+1;
        }
        if(m>=0 && n>=0){
            count2 = dfs(counts,index+1,m,n);
        }
        // countMemo.put(pair, Math.max(count1,count2));
        dp[index][m][n] = Math.max(count1,count2);
        return dp[index][m][n];
        // return countMemo.getOrDefault(pair,0);
    }
}




