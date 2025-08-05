class Solution {
    int[][] heights;
    boolean[][] visited;
    int n, m;
    public int swimInWater(int[][] grid) {
        n = grid.length;
        boolean[][] visited = new boolean[n][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        pq.offer(new int[]{grid[0][0],0,0});
        visited[0][0]=true;
        int elevation = 0;
        while(!pq.isEmpty()){
            int[] node = pq.poll();
            int i = node[1];
            int j = node[2];
            elevation = Math.max(node[0],elevation);
            if(i==n-1 && j==n-1)return elevation;
            int[][] indexs = {{0,1},{0,-1},{1,0},{-1,0}};
            for(int[] index : indexs){
                int row = index[0]+i;
                int col = index[1]+j;
                if(row<0 || row==n || col<0 || col==n || visited[row][col])continue;
                visited[row][col]=true;
                pq.offer(new int[]{grid[row][col],row,col});
            }
        }
        return -1;
    }


}




