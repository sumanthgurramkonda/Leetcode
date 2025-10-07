class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        // Arrays.sort(intervals, (a,b)->a[1]-b[1]);
        // int count=0;
        // int interValIndex=0;
        // for(int i=1;i<n && n>1;i++){
        //     if(intervals[interValIndex][1]>intervals[i][0]){
        //         count++;
        //     }else{
        //         interValIndex=i;
        //     }
        // }
        Arrays.sort(intervals, (a,b)-> a[0]==b[0] ? a[1]-b[1] : a[0]-b[0]);
        int count=0;
        int prevEnd = intervals[0][1];
        for(int i=1;i<n && n>1;i++){
            if(prevEnd>intervals[i][0]){
                count++;
                prevEnd = Math.min(intervals[i][1], prevEnd);
            }else{
                prevEnd = intervals[i][1];
            }
        }
        return count;
    }
}



