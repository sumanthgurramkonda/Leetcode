class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList();
        combinationSum(candidates,target,0,0,new ArrayList(),res);
        return res;
    }

    public void combinationSum(int[] candidate,int target, int start,int sum,List<Integer> list,List<List<Integer>> res){

        if(target==sum){
            res.add(new ArrayList(list));
            return;
        }
        if(sum>target){
            return;
        }
        for(int i = start;i<candidate.length;i++){
            list.add(candidate[i]);
            combinationSum(candidate,target,i,sum+candidate[i],list,res);
            list.remove(list.size()-1);
        }
    }
    
}