class Solution {
    public int minimumRightShifts(List<Integer> nums) {

        int n = nums.size();
        int index = -1;

        for(int i=1;i<n;i++){
            if(nums.get(i)<nums.get(i-1)){
                if(index!=-1)return -1;
                index = i;
            }
        }
        if(nums.get(n-1)>nums.get(0) && index!=-1)return -1;
        return index==-1 ? 0 : n-index;

    }
}
