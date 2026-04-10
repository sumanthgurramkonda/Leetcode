class Solution {
    class Node{
        int col, row;
        int dist;
        int k;
        public Node(int row,int col, int dist,int k){
            this.row = row;
            this.col = col;
            this.dist = dist;
            this.k = k;
        }
    }

    public int shortestPath(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        Node[][] gridNodes = new Node[n][m];
        int[][] visitedk = new int[n][m];
        for(int[] arr : visitedk) Arrays.fill(arr,-1);

        Queue<Node> pq = new LinkedList<>();

        k = k-grid[0][0];
        if(k<0)return -1;
        pq.offer(new Node(0,0,0,k));
        visitedk[0][0] = k;
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

        while(!pq.isEmpty()){
            int size = pq.size();
            for(int i=0;i<size;i++){
                Node node = pq.poll();
                if(node.row==n-1 && node.col==m-1)return node.dist;
                for(int[] dir : directions){
                    int row = node.row+dir[0];
                    int col = node.col+dir[1];
                    if(row<0 || col<0 || row>=n || col>=m ) continue;
                    int newK = node.k-grid[row][col];
                    if(newK<0)continue;
                    if(visitedk[row][col]>=newK) continue;
                    visitedk[row][col]=newK;
                    pq.add(new Node(row,col,node.dist+1,newK));
                }
            }
        }
        return -1;
    }
}




