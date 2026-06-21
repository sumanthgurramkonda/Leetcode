class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap();
        int n = nums1.length;
        int m = nums2.length;
        for(int i=0;i<m;i++){
           if(!map.containsKey(nums2[i])) map.put(nums2[i],i);
        }
        for(int i=0;i<n;i++){
            int j = map.get(nums1[i])+1;
            for(;j<m;j++){
                if(nums2[j]>nums1[i]){
                    nums1[i]=nums2[j];
                    break;
                }
            }
            if(j==m)nums1[i]=-1;
        }
        return nums1;
    }
}