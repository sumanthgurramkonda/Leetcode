class Solution {

    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int max = 0;
        int maxCount = 0;
        for(int n : nums){
            int count = countMap.getOrDefault(n, 0)+1;
            countMap.put(n, count);
            if(count==max) maxCount+=1;
            if(count>max){
                max = count;
                maxCount = 1;
            }
        }
        return maxCount*max;
    }
}




