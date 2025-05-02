class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {

        List<Boolean> res = new ArrayList(l.length);
        for(int i=0;i<l.length;i++){
            int n = r[i]-l[i];
            int[] arr = new int[n+1];
            for(int j=0;j<=n;j++){
                arr[j]=nums[j+l[i]];
                System.out.print(arr[j]+" ");
            }
            System.out.println();
            res.add(isArithmaticArray(arr));
        }
        return res;
    }

    public boolean isArithmaticArray(int nums[]){
        if(nums.length<2)return false;
        Arrays.sort(nums);
        int diff = nums[1]-nums[0];
        for(int i=2;i<nums.length;i++){
            if(!(nums[i]-nums[i-1]==diff)){
                return false;
            }
        }
        return true;
    }
}