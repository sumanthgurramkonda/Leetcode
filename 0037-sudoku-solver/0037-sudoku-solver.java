class Solution {
    private final int SIZE = 9;
    private Set<Character>[] rows = new Set[SIZE];;
    private Set<Character>[] cols = new Set[SIZE];;
    private Set<Character>[] boxes = new Set[SIZE];

    int count = 0;
    public void solveSudoku(char[][] board) {

        for(int i=0;i<SIZE;i++){
            rows[i] = new HashSet<Character>();
            cols[i] = new HashSet<Character>();
            boxes[i] = new HashSet<Character>();
        }
        
        for(int r=0;r<SIZE;r++){
            for(int c=0;c<SIZE;c++){
                if(board[r][c]=='.') continue;
                rows[r].add(board[r][c]);
                cols[c].add(board[r][c]);
                int boxIndex = (r/3)*3 + c/3;
                boxes[boxIndex].add(board[r][c]);
                count++;
            }
        }
        solveSudoku(board,0,0);

    }

    public boolean solveSudoku(char[][] grid, int row, int col){
        if(col==SIZE) return solveSudoku(grid,row+1,0);
        if(row==SIZE)return true;
        if(grid[row][col]!='.') return solveSudoku(grid,row,col+1);
        int boxIndex = (row/3)*3 + col/3;
        for(char ch ='1';ch<='9';ch++){
            if(!rows[row].contains(ch) && !cols[col].contains(ch) && !boxes[boxIndex].contains(ch)){
                rows[row].add(ch);
                cols[col].add(ch);
                boxes[boxIndex].add(ch);
                grid[row][col]=ch;
                if(solveSudoku(grid, row, col+1)) return true;
                grid[row][col]='.';
                rows[row].remove(ch);
                cols[col].remove(ch);
                boxes[boxIndex].remove(ch);

            }
        }
        return false;
    }

}




