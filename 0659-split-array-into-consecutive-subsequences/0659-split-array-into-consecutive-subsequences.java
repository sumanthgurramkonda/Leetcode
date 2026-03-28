class Solution {
    public boolean isPossible(int[] nums) {

        Map<Integer, Integer> freqMap = new HashMap<>();
        Map<Integer, Integer> appendable = new HashMap<>();
        
        for(int num : nums){
            freqMap.put(num, freqMap.getOrDefault(num,0)+1);
        }

        for(int num : nums){
            if(freqMap.get(num)==0)continue;
            if(appendable.getOrDefault(num-1,0)>0){
                freqMap.put(num,freqMap.get(num)-1);
                appendable.put(num-1, appendable.get(num-1)-1);
                appendable.put(num,appendable.getOrDefault(num,0)+1);
            }
            else if(freqMap.getOrDefault(num+1,0)>0 && freqMap.getOrDefault(num+2,0)>0){
                freqMap.put(num, freqMap.get(num)-1);
                freqMap.put(num+1, freqMap.get(num+1)-1);
                freqMap.put(num+2, freqMap.get(num+2)-1);
                appendable.put(num+2,appendable.getOrDefault(num+2,0)+1);
            }else {
                return false;
            }
        }
        return true;
    }
}