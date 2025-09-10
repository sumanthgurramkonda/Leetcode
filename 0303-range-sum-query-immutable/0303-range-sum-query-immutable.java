class NumArray {
    int nums1[];
    int nums2[];
    public NumArray(int[] nums) {
        this.nums1 = new int[nums.length];
        this.nums2 = new int[nums.length];
        this.nums1[0] = nums[0];
        this.nums2[0] = nums[0];
        for(int i=1;i<nums.length;i++){
            this.nums1[i] += this.nums1[i-1]+nums[i];
            this.nums2[i] = nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        return (nums1[right]-nums1[left]+nums2[left]);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */