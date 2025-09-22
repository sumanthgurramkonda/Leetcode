class Solution {

    List<String> res = new ArrayList();
    public List<String> generateParenthesis(int n) {
        generateParenthesis1(new StringBuilder(), 0,0,n);
        return res;
    }

    public void generateParenthesis1(StringBuilder s,int o, int c, int n){
        if(o==n && c==n){
            res.add(s.toString());
            return;
        }
        if(o<n){
            s.append("(");
            generateParenthesis1(s,o+1,c,n);
            s.deleteCharAt(s.length() - 1);
        }
        if(c<o){
            s.append(")");
            generateParenthesis1(s,o,c+1,n);
            s.deleteCharAt(s.length() - 1);
        }
    }
}
