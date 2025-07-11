class Solution {
    List<Integer> list = new LinkedList();
    public int[] numsSameConsecDiff(int n, int k) {

        for(int i=1;i<=9;i++){
            dfs(n-1,k,i,i);
        }
        int[] res = new int[list.size()];
        int i=0;
        for(int num : list){
            res[i++]=num;
        }
        return res;
    }

    public void dfs(int n,int k, int i, int num){
        if(n==0){
            list.add(num);
            return;
        }
        for(int j=0;j<=9;j++){
                if(Math.abs(i-j)==k){
                    dfs(n-1,k,j,(num*10)+j);
                }
        }
    }
}
