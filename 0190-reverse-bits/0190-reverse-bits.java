class Solution {
    public int reverseBits(int n) {
        int bits;
        int res=0;
        for(int i=1;i<=32;i++){
             bits = n >> i & 1;
             res = res | bits<<(31-i);
        }
        return res;
    }
}

