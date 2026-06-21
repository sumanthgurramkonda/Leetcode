class Solution {

    public String minWindow(String s, String t) {
        int n = s.length(), m = t.length();
        if(n<m) return "";
        int[] sFreq = new int[128];
        int[] tFreq = new int[128];
        for(char c : t.toCharArray()) tFreq[c]++;

        int required = 0, formed = 0;
        for(int i=0;i<126;i++){
            if(tFreq[i]>0)required++;
        }
        int left = 0;
        int l = 0, r = Integer.MAX_VALUE;
        for(int right=0; right<n; right++){
            char c = s.charAt(right);
            sFreq[c]++;
            if(tFreq[c]>0 && sFreq[c]==tFreq[c]){
                formed++;
            } 
            while(left<=right && formed>=required){
                char ch = s.charAt(left);
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



    public boolean isValidString(int[] sFreq, int[] tFreq, String t){

        for(char c : t.toCharArray()){
            if(tFreq[c]>0 && sFreq[c]<tFreq[c])return false;
        }
        return true;
    }

}