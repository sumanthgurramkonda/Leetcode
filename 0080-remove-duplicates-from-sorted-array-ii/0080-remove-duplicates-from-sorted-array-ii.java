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
        nums[pos]=nums[n-1];
        return pos+1;
    }
}