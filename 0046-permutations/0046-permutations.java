class Solution {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList(nums.length);
        // permutations(nums,0,res);
        permutations(nums,0,res);
        return res;
    }

    public void permutation(int[] nums, int index, List<List<Integer>> res){
        if(index==nums.length-1){
            List<Integer> list = new ArrayList();
            for(int n : nums)list.add(n);
            res.add(list);
        }

        for(int i=0;i<nums.length;i++){
            permutation(nums,index+1,res);
            int temp = nums[index];
            nums[index]=nums[index+1];
            nums[index+1]=temp;
            permutation(nums,index+1,res);
            temp = nums[index];
            nums[index]=nums[index+1];
            nums[index+1]=temp;
        }


    }








    public void permutations(int[] nums,int i,List<List<Integer>> res){

        if(i==nums.length){      
             List<Integer> list = new ArrayList();
            for(int n : nums)list.add(n);
            res.add(list);
            return;
        }
        for(int j=i;j<nums.length;j++){
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            permutations(nums,i+1,res);
            temp = nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
        }
    }
}