class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length())return false;
        int s1Len = s1.length();
        int[] s1Freq = new int[26];
        int[] s2Freq = new int[26];
        for(int i=0;i<s1Len;i++){
            s1Freq[s1.charAt(i)-'a']++;
            s2Freq[s2.charAt(i)-'a']++;
        }

        for(int i=0;i<s2.length()-s1Len;i++){
            if(Arrays.equals(s1Freq,s2Freq))return true;
            s2Freq[s2.charAt(i)-'a']--;
            s2Freq[s2.charAt(i+s1Len)-'a']++;
        }
        return Arrays.equals(s1Freq,s2Freq);
    }
}