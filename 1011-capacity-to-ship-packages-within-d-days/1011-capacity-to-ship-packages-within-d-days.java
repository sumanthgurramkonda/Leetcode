class Solution {
    public int shipWithinDays(int[] weights, int days) {

        int totalWeight = 0;
        int maxWeight = 0;
        for(int weight : weights){
            totalWeight += weight;
            maxWeight = Math.max(maxWeight, weight);
        }

        int left = maxWeight, right = totalWeight;
        int res = totalWeight;
        while(left<right){
            int mid = (left+right)/2;
            int currentDays = getDays(weights,mid);
            if(currentDays<days){
                right = mid;
            }else{
                left=mid+1;
            }
        }
        return left;
    }

    public int getDays(int[] weights, int maxWeight){

        int dayCount = 0;
        int currentWeight = 0;

        for(int weight : weights){

            if(currentWeight+weight <= maxWeight){
                currentWeight+= weight;
            }else{
                currentWeight=weight;
                dayCount++;
            }
        }

        return dayCount;
    }
}