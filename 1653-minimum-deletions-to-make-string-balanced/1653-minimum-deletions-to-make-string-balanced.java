class Solution {

    public int minimumDeletions(String s) {

        int n = s.length();
        int aCount = 0, bCount=0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='a')aCount++;
        }
        if(aCount==0 || aCount==n)return 0;
        int minDel = aCount;
        for(char c : s.toCharArray()){
            if(c=='a'){
                aCount--;
            }else bCount++;
            minDel = Math.min(minDel, aCount+bCount);
        }
        return minDel;
    }
    
}


