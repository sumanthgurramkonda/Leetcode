class Solution {

    public String minWindow(String s, String t) {
        int n = s.length(), m = t.length();
        if(n<m) return "";
        int[] sFreq = new int[52];
        int[] tFreq = new int[52];
        for(char c : t.toCharArray()) tFreq[getIndex(c)]++;

        int required = 0, formed = 0;
        for(int i=0;i<52;i++){
            if(tFreq[i]>0)required++;
        }
        int left = 0;
        int l = 0, r = Integer.MAX_VALUE;
        for(int right=0; right<n; right++){
            int c = getIndex(s.charAt(right));
            sFreq[c]++;
            if(tFreq[c]>0 && sFreq[c]==tFreq[c]){
                formed++;
            } 
            while(left<=right && formed>=required){
                int ch = getIndex(s.charAt(left));
                if(tFreq[ch]>0){
                    if(r-l >  right-left){
                        l = left;
                        r = right;
                    }
                }
                sFreq[ch]--;
                if(tFreq[ch]> 0 && sFreq[ch]<tFreq[ch]){
                    formed--;
                }
                left++;
            }
            
        }
        return r==Integer.MAX_VALUE ? "" : s.substring(l, r+1);

    }
    
    public int getIndex(char c){
        if(c>='a' && c<='z') return c-'a';
        return c-'A'+26;
    }

}