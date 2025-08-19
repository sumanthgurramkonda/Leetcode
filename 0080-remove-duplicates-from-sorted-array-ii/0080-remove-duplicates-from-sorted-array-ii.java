class Solution {
    public int removeDuplicates(int[] nums) {

        int counter = 0;
        int pos = 0;
        int n = nums.length;
        for(int i=0;i<n-1;i++){
            if(nums[i]==nums[i+1]){
                counter+=1;
            }else{
                counter = 0;
            }
            if(counter<2){
                nums[pos]=nums[i];
                pos+=1;
            }
        }
        if(pos<n)nums[pos]=nums[n-1];
        for(int num : nums) System.out.print(num+" ");
        return pos+1;
    }
}