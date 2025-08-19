class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        if(n==1)return nums[0];
        int res=nums[0];
        int counter=1;
        for(int i=1;i<n;i++){
             if(counter==0){
                res = nums[i];
                counter=1;
            }
            else if(nums[i]==res){
                counter++;
            }else{
                counter--;
            }
        }
        return res;
    }
}