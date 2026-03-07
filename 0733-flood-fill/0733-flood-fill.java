class Solution {
    int num = -1;
    int[][] indexes = {{1,0},{-1,0},{0,1},{0,-1}};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(sr<0 || sr>=image.length || sc<0 || sc>=image[0].length)return image;
        if(num==-1)num = image[sr][sc];
        if(image[sr][sc]!=num || image[sr][sc]==color)return image;
        image[sr][sc]=color;
        for(int[] index : indexes){
            int r = sr + index[0];
            int c = sc + index[1];
            floodFill(image,r,c,color);
        }
        return image;
    }
}

