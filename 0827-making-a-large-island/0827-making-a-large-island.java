class Solution {
    public int largestIsland(int[][] grid) {

        int maxArea = 0;
        int paint = 2;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==1){
                    int area = dfs(grid,i,j,paint);
                    maxArea = Math.max(area, maxArea);
                    map.put(paint, area);
                    paint++;
                }
            }
        }

        if(maxArea == grid.length * grid[0].length)return maxArea;

        int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==0){
                    int area = 1;
                    Set<Integer> seen = new HashSet<>();
                    for(int[] dr : dir){
                        int r = i+dr[0];
                        int c = j+dr[1];
                        if(r>=0 && r<grid.length && c>=0 && c<grid[0].length){
                            int color = grid[r][c];
                            if(color>1 && !seen.contains(color)){
                                area += map.get(grid[r][c]);
                                seen.add(color);
                            }
                        }
                    }
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }

    public int dfs(int[][] grid, int i, int j, int paint){

        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length) return 0;
        if(grid[i][j]!=1)return 0;
        grid[i][j] = paint;

        int sum = 1;
        sum += dfs(grid,i,j+1,paint);
        sum += dfs(grid,i,j-1,paint);
        sum += dfs(grid,i+1,j,paint);
        sum += dfs(grid,i-1,j,paint);

        return sum;
    }
}