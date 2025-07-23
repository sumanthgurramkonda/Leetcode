class Solution {
    
    public int orangesRotting(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        int fresh = 0;
        Queue<int[]> rottenQueue = new LinkedList();
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    rottenQueue.offer(new int[]{i,j});
                }
                if(grid[i][j]==1)fresh+=1;
            }
        }
        if(fresh==0)return 0;
        int minTime = 0;
        while(!rottenQueue.isEmpty()){
            int size = rottenQueue.size();
            if(fresh==0)return minTime;
            minTime++;
            for(int k=0;k<size;k++){
                int[] arr = rottenQueue.poll();
                int i = arr[0], j = arr[1];
                if(i-1>=0 && grid[i-1][j]==1){
                    rottenQueue.offer(new int[]{i-1,j});
                    fresh--;
                    grid[i-1][j]=2;
                }
                if(i+1<n && grid[i+1][j]==1){
                    rottenQueue.offer(new int[]{i+1,j});
                    fresh--;
                    grid[i+1][j]=2;
                }
                if(j-1>=0 && grid[i][j-1]==1){
                    rottenQueue.offer(new int[]{i,j-1});
                    fresh--;
                    grid[i][j-1]=2;
                }
                if(j+1<m && grid[i][j+1]==1){
                    rottenQueue.offer(new int[]{i,j+1});
                    fresh--;
                    grid[i][j+1]=2;
                }
            }
        }
        return -1;
    }

}

  


