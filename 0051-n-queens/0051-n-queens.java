class Solution {
    
    public class Pair{
        public int row;
        public int col;
        public Pair(int row, int col){
            this.row=row;
            this.col=col;
        }
    }

    List<List<String>> res = new LinkedList();
    List<Pair> pairs = new LinkedList<>();
    
    public List<List<String>> solveNQueens(int n) {
        solveNQueens1(n,0);
        return res;
    }

    public void solveNQueens1(int n, int row){
        if(row>=n){
            List<String> list = new LinkedList();
            for(Pair pair : pairs){
                StringBuilder str = new StringBuilder();
                for(int col=0;col<n;col++){
                    if(pair.col==col)str.append('Q');
                    else str.append('.');
                }
                list.add(str.toString());
            }
            res.add(list);
            return;
        }
        for(int col=0;col<n;col++){
            if(isValidPosition(row,col)){
                pairs.add(new Pair(row,col));
                solveNQueens1(n, row+1);
                pairs.remove(pairs.size()-1);
            }  
        }
    }

    public boolean isValidPosition(int r, int c){
        
        for(Pair pair : pairs){
            int row = pair.row;
            int col = pair.col;
            if(col==c || Math.abs(row-r)==Math.abs(col-c))return false;
        }
        return true;
    }

    public StringBuilder generateString(int n){
        StringBuilder str = new StringBuilder();
        for(int i=0;i<n;i++){
            str.append('.');
        }
        return str;
    }
}