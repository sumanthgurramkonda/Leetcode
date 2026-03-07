class Solution {
    public void solve(char[][] board) {

        char c = '1';
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='O' && (i==0 || i==board.length-1||j==0||j==board[i].length-1)){
                    dfs(board,i,j,c);
                }
            }
        }
        // for(int i=0;i<board.length;i++){
        //     for(int j=0;j<board[0].length;j++){
        //         if(board[i][j]=='O'){
        //             dfs(board,i,j,'X');
        //         }
        //     }
        // }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==c){
                    board[i][j]='O';
                }
                else if(board[i][j]=='O'){
                    // dfs(board,i,j,'X');
                    board[i][j]='X';
                }
            }
        }
        
    }
    private class Pair{
        int first;
        int second;
        Pair(int first,int second){
            this.first = first;
            this.second = second;
        }
    }
    public void dfs(char[][] board,int i,int j,char cell){
        board[i][j]=cell;
        int arr[][] = {{-1,0},{0,-1},{1,0},{0,1}};
        for(int k=0;k<4;k++){
            int r = i+arr[k][0];
            int c = j+arr[k][1];
            if(r>=0 && r<board.length && c>=0 && c<board[0].length && board[r][c]=='O'){
                dfs(board,r,c,cell);
            }
        }

    }
}