class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a,b)->a[1]-b[1]);
        int count=0;
        int interValIndex=0;
        for(int i=1;i<n && n>1;i++){
            if(intervals[interValIndex][1]>intervals[i][0]){
                count++;
            }else{
                interValIndex=i;
            }
        }
        return count;
    }
}



