class Solution {
    boolean[] memo;
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        memo = new boolean[n];
        Arrays.fill(memo,false);
        int count = 0;
        for(int i=0;i<n;i++){
            if(!memo[i]){
                count+=1;
                findProvinces(isConnected,i);
            }
        }
        return count;
    }

    public void findProvinces(int[][] isConnected,int i){
        for(int j=0;j<isConnected.length;j++){
            if(!memo[j] && isConnected[i][j]==1){
                memo[j]=true;
                findProvinces(isConnected,j);
            }
        }
    }
}