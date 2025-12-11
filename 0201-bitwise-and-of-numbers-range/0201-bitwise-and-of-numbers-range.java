class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int count=0;
        while(right!=left){
            left = left>>1;
            right = right>>1;
            count++;
        }
        return left<<count;
    }
}

