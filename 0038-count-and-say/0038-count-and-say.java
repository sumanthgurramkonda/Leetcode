class Solution {
    public String countAndSay(int n) {
        String res = null;
        for(int i=0;i<n;i++){
            res = compress(res);
        }
        return res;
    }


    public String compress(String s){
        if(s==null)return "1";
        StringBuilder str = new StringBuilder();
        int count = 1;
        int n = s.length();
        for(int i=0;i<n-1;i++){
            if(s.charAt(i)==s.charAt(i+1)){
                count++;
            }else{
                str.append(count);
                str.append(s.charAt(i));
                count=1;
            }
        }
        str.append(count);
        str.append(s.charAt(n-1));
        return str.toString();
    }
}




