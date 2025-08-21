class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int n = gas.length;
        int gasSum = 0;
        int costSum = 0;
        for(int i=0;i<n;i++){
            gasSum += gas[i];
            costSum += cost[i];
        }
        if(gasSum<costSum)return -1;
        int res = 0;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=gas[i]-cost[i];
            if(sum<0){
                sum = 0;
                res=i+1;
            }
        }
        return res;
    }
}




