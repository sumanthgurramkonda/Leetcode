class Solution {
    public int lengthOfLIS(int[] nums) {

        List<Integer> sortedNumsList = new ArrayList<>();

        for(int num : nums){
            int left = 0;
            int right = sortedNumsList.size();
           
            while(left<right){
                int mid = left + (right-left)/2;
                if(sortedNumsList.get(mid)<num){
                    left = mid+1;
                }else{
                    right = mid;
                }
            }
            if(left==sortedNumsList.size())sortedNumsList.add(num);
            else sortedNumsList.set(left, num);
        }
        return sortedNumsList.size();
    }
}