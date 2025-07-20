class Solution {
    public int islandPerimeter(int[][] grid) {

        int perimeter = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                int left=0,right=0,top=0,down=0;
                if(grid[i][j]==1){
                    if(isLand(i-1,j,grid)){
                        top = 1;
                    }
                    if(isLand(i+1,j,grid)){
                        down = 1;
                    }
                    if(isLand(i,j-1,grid)){
                        left = 1;
                    }
                    if(isLand(i,j+1,grid)){
                        right = 1;
                    }
                }
                perimeter += (top+down+left+right);
            }
        }
        return perimeter;
    }

    public boolean isLand(int i, int j,int[][]grid){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length)return true;
        return grid[i][j]==0;
    }

}


