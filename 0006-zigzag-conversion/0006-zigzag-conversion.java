class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1)return s;
        StringBuilder str[] = new StringBuilder[numRows];
        for(int i=0;i<numRows;i++){
            str[i] = new StringBuilder();
        }

        int index=0;
        while(index<s.length()){
            for(int i=0;i<numRows && index<s.length();i++){
                str[i].append(s.charAt(index++));
            }
            for(int i=numRows-2;i>0 && index<s.length();i--){
                str[i].append(s.charAt(index++));
            }
        }

        StringBuilder res = new StringBuilder();
        for(StringBuilder sb : str){
            res.append(sb);
        }
        return res.toString();
        
    }
}

/* 
0 - 0 - P
1 - 1 - A
2 - 2 - Y
3 - 1 - P
4 - 0 - A
5 - 1 - L
6 - 2 - I
7 - 1 - S
8 - 0 - H
9 - 1 - I
10 - 2 - R
11 - 1 - I
12 - 0 - N
13 - 1 - G

*/