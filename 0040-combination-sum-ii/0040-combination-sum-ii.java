class Solution {
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList();
        combinationSum(candidates,target,0,0,new ArrayList(),res);
        return res;
    }

    public void combinationSum(int[] candidates,int target, int sum, int start,List<Integer> list, List<List<Integer>> res){
        if(target==sum){
            res.add(new ArrayList(list));
            return;
        }
        if(start==candidates.length || sum>target)return;
        for(int i=start;i<candidates.length;i++){
            if(i>start && candidates[i]==candidates[i-1])continue;
            list.add(candidates[i]);
            combinationSum(candidates,target,sum+candidates[i],i+1,list,res);
            list.removeLast();
        }
    }
    
}