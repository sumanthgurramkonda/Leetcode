class Solution {
    int res = 0;
    public int findKthLargest(int[] nums, int k) {

        int n=nums.length;
        k = n-k;
        return devide(nums,k,0,n-1);
        // return res;
        // return findElement(nums,k);
    }

    public int devide(int[] nums,int k,int start,int end){

        while(start<end){
            int pivot = nums[end];
            int low = start;
            int high = end;
            // for(int i=start;i<end;i++){
            //     if(nums[i]<pivot){
            //         if(i!=low)swap(nums,i,low);
            //         low++;
            //     }
            // }
            // swap(nums,low,end);
            while(low<=high){
                while(low<=high && nums[low]<pivot)low++;
                while(low<=high && nums[high]>pivot)high--;
                if(low<=high){
                    swap(nums,low,high);
                    low++;
                    high--;
                }
            }
            if(k<=high)end=high;
            else if(k>=low) start=low;
            else return nums[k];
        }
        return nums[k];

        // if(start>end)return nums[k];
        // int pivot = nums[end];
        // int low = start;
        // for(int i=start;i<end;i++){
        //     if(nums[i]<pivot){
        //         swap(nums,i,low);
        //         low++;
        //     }
        // }
        // swap(nums,low,end);
        
        // if(low==k) return nums[k];
        // if(low>k)devide(nums,k,start,low-1);
        // else devide(nums,k,low+1,end);
        // return nums[k];
    }


    public void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

}