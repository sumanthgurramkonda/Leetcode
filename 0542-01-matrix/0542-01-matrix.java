class Solution {
    public int[][] updateMatrix(int[][] mat) {

        Queue<int[]> matQueue = new LinkedList();
        int n = mat.length;
        int m = mat[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==1){
                    mat[i][j]=Integer.MAX_VALUE;
                }else matQueue.offer(new int[]{i,j});
            }
        }
        
        while(!matQueue.isEmpty()){
            int size = matQueue.size();
            int[] node = matQueue.poll();
            int i = node[0], j = node[1];
            if(i-1>=0 && mat[i-1][j]>mat[i][j]){
               mat[i-1][j] = mat[i][j]+1;
               matQueue.offer(new int[]{i-1,j});
            }
            if(i+1<n && mat[i+1][j]>mat[i][j]){
               mat[i+1][j] = mat[i][j]+1;
               matQueue.offer(new int[]{i+1,j});
            }
            if(j-1>=0 && mat[i][j-1]>mat[i][j]){
               mat[i][j-1] = mat[i][j]+1;
               matQueue.offer(new int[]{i,j-1});
            }
             if(j+1<m && mat[i][j+1]>mat[i][j]){
               mat[i][j+1] = mat[i][j]+1;
               matQueue.offer(new int[]{i,j+1});
            }
        }
        return mat;
    }
}

