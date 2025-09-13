class Solution {
    public String minWindow(String s, String t) {
        if(s.length()<t.length()) return "";
        
        int[] sFreq = new int[128];
        int[] tFreq = new int[128];

        for(char c : t.toCharArray()){ 
            tFreq[c]+=1;
        }
        int required = 0, formed=0;
        for(int count : tFreq){
            if(count>0) required+=1;
        }
        int left = 0,right = 0;
        int l=0,r=Integer.MAX_VALUE;
        while(right<s.length()){
            char c = s.charAt(right);
            sFreq[c]++;
            if (tFreq[c] > 0 && sFreq[c] == tFreq[c]) {
                formed++;
            }
            while(left<=right && formed>=required){
                if(right-left < r-l){
                    r = right;
                    l = left;
                }
                if(tFreq[s.charAt(left)]<=0){
                    left++;
                    continue;
                }
                char leftChar = s.charAt(left);
                sFreq[leftChar]--;
                if (tFreq[leftChar] > 0 && sFreq[leftChar] < tFreq[leftChar]) {
                    formed--;
                }
                left++;
            }
            right+=1;
        }
        return r==Integer.MAX_VALUE ? "" : s.substring(l,r+1);
    }

    public boolean isValidString(int[]sFreq,int[]tFreq,String t){
        for(char c : t.toCharArray()){
            if(sFreq[c]<tFreq[c]) return false;
        }
        return true;
    }
}