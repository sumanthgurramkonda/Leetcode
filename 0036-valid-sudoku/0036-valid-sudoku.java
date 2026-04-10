class Solution {

    public boolean isValidSudoku(char[][] board) {

        Set<Character>[] rows = new Set[9];
        Set<Character>[] columns = new Set[9];
        Set<Character>[] boxes = new Set[9];

        for(int i=0;i<9;i++){
            rows[i] = new HashSet<Character>();
            columns[i] = new HashSet<Character>();
            boxes[i] = new HashSet<Character>();
        }

        for(int r=0;r<9;r++){
            for(int c=0;c<9;c++){
                char ch = board[r][c];
                if(ch=='.') continue;
                int b = (r/3)*3+(c/3);
                if(rows[r].contains(ch) || columns[c].contains(ch) || boxes[b].contains(ch)) return false;
                rows[r].add(ch);
                columns[c].add(ch);
                boxes[b].add(ch);
            }
        }
        
        return true;
    }
}

 