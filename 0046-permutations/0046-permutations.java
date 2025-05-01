class Solution {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList(nums.length);
        permutations(nums,0,res);
        return res;
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