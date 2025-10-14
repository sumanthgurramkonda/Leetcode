class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        if(n<=1)return n;
       Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) return b[1] - a[1];
            return a[0] - b[0];
        });
        int[] dp = new int[n];
        // Arrays.fill(dp,1);
        // for(int i=0;i<n-1;i++){
        //    for(int j=i+1;j<n;j++){
        //     if(envelopes[i][1]<envelopes[j][1]){
        //         dp[j] = Math.max(dp[i]+1,dp[j]);
        //     }
        //    }
        // }
        int len = 0;
        for(int i=0;i<n;i++){
            int index = binarySearch(dp,0,len,envelopes[i][1]);
            dp[index]=envelopes[i][1];
            if(index==len)len++;
        }
        
        return len;
    }

    public int binarySearch(int[] dp,int l,int r, int target){

        while(l<r){
            int m = (l+r)/2;
            if(dp[m]<target){
                l = m+1;
            }else {
                r = m;
            }
        }

        return l;
    }
}