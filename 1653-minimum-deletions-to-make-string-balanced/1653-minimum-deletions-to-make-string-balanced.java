class Solution {

    public int minimumDeletions(String s) {

        int n = s.length();
        int aCount = 0, bCount=0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='a')aCount++;
        }
        if(aCount==0 || aCount==n)return 0;
        int minDel = n;
        for(char c : s.toCharArray()){
            if(c=='a'){
                aCount--;
            }
            minDel = Math.min(minDel, aCount+bCount);
            if(c=='b') bCount++;
        }
        return minDel;
    }
    
}


