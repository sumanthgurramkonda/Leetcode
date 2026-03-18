class Solution {
    public boolean stoneGame(int[] piles) {
        // return true;
        int[] arr = dfs(piles,0,piles.length-1,0);
        return arr[0]>arr[1];
    }

    public int[] dfs(int[]piles, int left, int right, int alice){
        if(left>right)return new int[2];
        int arr[]=new int[2];
        if(alice==0){
            if(piles[left]>piles[right]){
                arr[0] += piles[left]+dfs(piles,left+1,right,1-alice)[0];
            }else{
                arr[0] += piles[right]+dfs(piles,left,right-1,1-alice)[0];
            }
        }else{
            if(piles[left]>piles[right]){
                arr[1] += piles[left]+dfs(piles,left+1,right,1-alice)[1];
            }else{
                arr[1] += piles[right]+dfs(piles,left,right-1,1-alice)[1];
            }
        }
        return arr;
    }
}




