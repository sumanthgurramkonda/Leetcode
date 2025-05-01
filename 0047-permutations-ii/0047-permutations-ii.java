class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList(nums.length);
        Set<String> set = new HashSet();
        boolean[] visited = new boolean[nums.length];
        permutations(nums,0,res,set,visited);
        return res;
    }

    public void permutations(int[] nums,int i,List<List<Integer>> res,Set<String> set,boolean[] visited){

        if(i==nums.length){      
            List<Integer> list = new ArrayList();
            // StringBuilder str = new StringBuilder();
            for(int n : nums){
                list.add(n);
                // str.append(n+"");
            }
            // if(!set.contains(str.toString())){
            //     set.add(str.toString());
            //     res.add(list);
            // }
            res.add(list);
            return;
        }
        for(int j=i;j<nums.length;j++){
            if(isVisited(nums,i,j))continue;
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            permutations(nums,i+1,res,set,visited);
            visited[i]=false;
            temp = nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
        }
    }

    public boolean isVisited(int[] nums, int start, int end){

        for(int i=start;i<end;i++){
            if(nums[i]==nums[end])return true;
        }
        return false;
    }

}