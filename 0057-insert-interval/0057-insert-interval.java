class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        int[][] newIntervals = new int[n+1][2];
        for(int i=0;i<n;i++){
            newIntervals[i] = intervals[i];
        }   
        newIntervals[n] = newInterval;
        Arrays.sort(newIntervals,(a,b)->a[0]-b[0]);

        Stack<int[]> intervalStack = new Stack<>();

        for(int[] interval : newIntervals){
            if(intervalStack.isEmpty()){
                intervalStack.push(interval);
                continue;
            }else {
                    int[] interval1 = intervalStack.peek();
                    if(interval1[1]<interval[0]){
                        intervalStack.push(interval);
                    }
                    if(interval1[1]>=interval[0]){
                        interval1[1] = Math.max(interval1[1], interval[1]);
                    }
                    
            }
        }
        int[][] res = new int[intervalStack.size()][2];
        for(int i = intervalStack.size()-1;i>=0;i--){
            res[i] = intervalStack.pop();
        }
        return res;
    }
}


// [1,3] , [2,5], [6,9];

// [1,2] [3,5],[4,8],[6,7],[8,10],[12,16]
//    [1,2] [3,10],[12,16]


