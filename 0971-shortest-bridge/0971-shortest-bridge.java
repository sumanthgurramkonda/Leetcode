class Solution {

    class Pair{
        int row;
        int col;
        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }

        @Override
        public int hashCode() {
            // int result = 17; // start with a non-zero prime
            // result = 31 * result + Integer.hashCode(row);
            // result = 31 * result + Integer.hashCode(col);
            // return result;
            return Objects.hash(row,col);
        }
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof Pair)) return false;
            Pair other = (Pair) obj;
            return this.row == other.row && this.col == other.col;
        }
    }
    
    Set<Pair> visited = new HashSet();
    Queue<Pair> queue = new LinkedList();

    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        boolean isPresent = false;
        for(int i=0;i<n && !isPresent;i++){
            for(int j=0;j<n && !isPresent;j++){
                if(grid[i][j]==1){ 
                    findIslands(grid,i,j,n);
                    isPresent = true;
                }
            }
        }
        return findMinDistance(grid,n);
    }

    public void findIslands(int[][] grid, int r, int c, int n){
        if(r<0 || r >=n || c<0 || c>=n || grid[r][c]!=1)return;
        Pair pair = new Pair(r,c);
        if(visited.contains(pair))return;
        visited.add(pair);
        queue.add(pair);
        grid[r][c]=-1;
        findIslands(grid,r-1,c,n);
        findIslands(grid,r+1,c,n);
        findIslands(grid,r,c-1,n);
        findIslands(grid,r,c+1,n);
    }

    public int findMinDistance(int[][] grid,int n){
        int[][] direct = {{1,0},{-1,0},{0,1},{0,-1}};
        int steps = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                Pair pair = queue.poll();
                for(int[] dir : direct){
                    int r = pair.row+dir[0];
                    int c = pair.col+dir[1];
                    Pair p = new Pair(r,c);
                    if(r<0 || r >=n || c<0 || c>=n || visited.contains(p)) continue;
                    if(grid[r][c]==1) return steps;
                    queue.offer(p);
                    visited.add(p);
                    
                }
            }
            steps+=1;
        }
        return -1;
    }

}




