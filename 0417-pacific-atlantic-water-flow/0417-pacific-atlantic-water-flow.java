class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int row = heights.length, col = heights[0].length;
        List<List<Integer>> res = new ArrayList();
        if(col==0 || row==0)return res;
        boolean[][] atlantic = new boolean[row][col];
        boolean[][] pacific = new boolean[row][col];
        for(int i=0;i<col;i++){
            pacificAtlantic(heights,pacific,Integer.MIN_VALUE,0,i);
            pacificAtlantic(heights,atlantic,Integer.MIN_VALUE,row-1,i);
        }
        for(int i=0;i<row;i++){
            pacificAtlantic(heights,pacific,Integer.MIN_VALUE,i,0);
            pacificAtlantic(heights,atlantic,Integer.MIN_VALUE,i,col-1);
        }

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(atlantic[i][j] && pacific[i][j]){
                    res.add(Arrays.asList(i,j));
                }
            }
        }
        return res;
        
    }

    int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    public void pacificAtlantic(int[][] heights, boolean[][] ocean, int curr, int i, int j){
        int n = heights.length, m = heights[0].length;
        if(i<0 || i>=n || j<0 || j>=m) return;
        if(heights[i][j]<curr || ocean[i][j])return;
        ocean[i][j]=true;
        for(int[]dr : dir){
            pacificAtlantic(heights,ocean,heights[i][j],i+dr[0],j+dr[1]);
        }
    }
}




