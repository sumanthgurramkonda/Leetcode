class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' '){
                sb.append(' ');
                while(i<s.length() && s.charAt(i)==' ') i++;
                if(i>=s.length())break;
            }
            sb.append(s.charAt(i));
        }
        String str[]  = sb.toString().split(" ");
        sb.setLength(0);
        for(int i = str.length-1;i>=0;i--){
            sb.append(str[i]);
            sb.append(' ');
        }
        return sb.toString().trim();
    }
}