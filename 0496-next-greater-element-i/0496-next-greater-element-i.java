class Solution {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int n = nums1.length, m = nums2.length;
        int[] greaterElements = new int[m];
        Arrays.fill(greaterElements,-1);

        for(int i=m-2;i>=0;i--){
            int index = i+1;
            while(index<m && nums2[index] <= nums2[i]){
                index = greaterElements[index];
                if(index==-1){
                    index = m;
                }
            }
            if(index<m) greaterElements[i] = index;
        }
        for(int num : greaterElements){
            System.out.println(num+" ");
        }
        Map<Integer, Integer> charMap = new HashMap<>();
        for(int i=0;i<m;i++){
            charMap.put(nums2[i], i);
        }
        int[] res = new int[n];

        for(int i=0;i<n;i++){
            int index = charMap.getOrDefault(nums1[i], -1);
            if(index!=-1 && greaterElements[index]!=-1){
                res[i] = nums2[greaterElements[index]];
            }else{
                res[i] = -1;
            }
        }
        return res;
    }
}