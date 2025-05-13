class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList();
        combinationSum(k,n,0,1,new ArrayList(),res);
        return res;
    }

    public void combinationSum(int k, int n, int sum, int start, List<Integer> list, List<List<Integer>> res){
        if(k==0){
            if(sum==n)
              res.add(new ArrayList(list));
            return;
        }
        for(int i=start;i<=9;i++){
            list.add(i);
            combinationSum(k-1,n,sum+i,i+1,list,res);
            list.removeLast();
        }
    }
}