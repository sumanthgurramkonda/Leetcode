class Solution {

    public int[] getOrder(int[][] tasks) {

        int tasksCount = tasks.length;
        int[][] tasksWithIndex = new int[tasksCount][3];
        int index = 0;
        for(int i=0;i<tasksCount;i++){
            tasksWithIndex[i][0] = i;
            tasksWithIndex[i][1] = tasks[i][0];
            tasksWithIndex[i][2] = tasks[i][1];
        }
        Arrays.sort(tasksWithIndex,(a,b)->a[1]-b[1]);
        PriorityQueue<int[]> taskQueue = new PriorityQueue<>((a,b)->a[2]==b[2] ? a[0]-b[0] : a[2]-b[2]);
        int i = 0, ind=0;
        int currentTime = 0;
        int[] res = new int[tasksCount];
        while(ind<tasksCount){
            while(i<tasksCount && tasksWithIndex[i][1]<=currentTime){
                taskQueue.add(tasksWithIndex[i]);
                i++;
            }
            if(taskQueue.isEmpty()){
                currentTime = tasksWithIndex[i][1];
                continue;
            }
            int[] task = taskQueue.poll();
            res[ind++] = task[0];
            currentTime += task[2];
            
        }
       return res;
    }

}


