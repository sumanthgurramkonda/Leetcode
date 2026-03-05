class Solution {

    Set<String> set = new HashSet<>();
    List<String> res = new ArrayList<>();
    boolean[][] visited;
    int maxLength = 0;
    public List<String> findWords(char[][] board, String[] words) {

        visited = new boolean[board.length][board[0].length];
        for(String word : words){
            set.add(word);
            maxLength = Math.max(maxLength, word.length());
        }
        StringBuilder str = new StringBuilder();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                dfs(board, i, j,str);
            }
        }
        return res;
    }
    int[][] indexs = {{1,0},{-1,0},{0,1},{0,-1}};
    public void dfs(char[][] board, int i, int j,StringBuilder word){
        if(word.length()>maxLength)return;
        if(set.contains(word.toString())){
            res.add(word.toString());
            set.remove(word.toString());
        }
        if(i<0 || i>=board.length || j<0 || j>=board[0].length || visited[i][j]) return;
        word.append(board[i][j]);
        visited[i][j]=true;
        for(int[] index : indexs){
            int l = i+index[0];
            int r = j+index[1];
            dfs(board, l ,r, word);
        }
        visited[i][j]=false;
        word.deleteCharAt(word.length()-1);
    }
}




