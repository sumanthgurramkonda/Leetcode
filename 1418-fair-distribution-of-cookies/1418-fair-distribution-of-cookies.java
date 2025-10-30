class Solution {

    int[] cookiesSum;
    int max=0;
    int min=Integer.MAX_VALUE;
    
    public int distributeCookies(int[] cookies, int k) {
        cookiesSum = new int[k];
        return dfs(cookies,0);
    }

    public int dfs(int[] cookies, int index){
        if(index==cookies.length){
            int maxValue = Integer.MIN_VALUE;
            for(int val : cookiesSum){
                maxValue = Math.max(val, maxValue);
            }
            return maxValue;
        }
        int minSum = Integer.MAX_VALUE;
        for(int i=0;i<cookiesSum.length;i++){
            cookiesSum[i]+=cookies[index];
            minSum= Math.min(minSum,dfs(cookies, index+1));
            cookiesSum[i]-=cookies[index];
            if(cookiesSum[i]==0)break;
        }
        return minSum;
    }
}


