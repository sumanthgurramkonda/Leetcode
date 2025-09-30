class MyCalendarTwo {


    List<int[]> overLappingList;
    List<int[]> nonOverLappingList;
    public MyCalendarTwo() {
        overLappingList = new ArrayList();
        nonOverLappingList = new ArrayList();
    }
    
    public boolean book(int startTime, int endTime) {
        for(int[] arr : overLappingList){
            if(endTime > arr[0] && startTime < arr[1]){
                return false;
            }
        }
        for(int[] arr : nonOverLappingList){
            if(endTime > arr[0] && startTime < arr[1]){
                int s = Math.max(arr[0], startTime);
                int e = Math.min(arr[1], endTime);
                overLappingList.add(new int[]{s,e});
            }
        }
        nonOverLappingList.add(new int[]{startTime,endTime});
        return true;
    }
}

/**
5 - 10
5 - 15
10 - 20
10 - 40
25 - 55
50 - 60

    10 - 20
                    50 - 60
    10     -    40 
5   -  15
5 - 10
            25    -    55

 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(startTime,endTime);
 */