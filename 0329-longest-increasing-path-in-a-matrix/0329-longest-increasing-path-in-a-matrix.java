class Solution {
    int[][] memo;
    boolean[][] visited;
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;

        visited = new boolean[n][m];
        memo = new int[n][m];

        for(int[] arr : memo) Arrays.fill(arr,-1);

        int maxPathSize = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                maxPathSize = Math.max(maxPathSize, dfs(matrix, i,j));
            }
        }
        return maxPathSize;
    }


    int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

    public int dfs(int[][] matrix, int row, int col){

        if(visited[row][col])return 0;
        if(memo[row][col]!=-1)return memo[row][col];

        int maxPathSize = 0;

        visited[row][col] = true;
        for(int[] dir : directions){
            int r = row+dir[0];
            int c = col+dir[1];
            if(r<0 || r>=matrix.length || c<0 || c >= matrix[0].length || matrix[row][col]>=matrix[r][c]) continue;
            maxPathSize = Math.max(maxPathSize, dfs(matrix, r,c));
        }
        visited[row][col]=false;

        return memo[row][col]=maxPathSize+1;
    }
}