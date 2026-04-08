class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length()!=goal.length()) return false;
        StringBuilder s1 = new StringBuilder(s);
        StringBuilder s2 = new StringBuilder();
        for(int i = 0;i<s.length();i++){
            s1.deleteCharAt(0);
            s2.append(s.charAt(i));
            String str = s1.toString() + s2.toString();
            if(str.equals(goal)) return true;
        }
        return false;
    }
}