class Solution {
    
    Map<Integer, Integer> map = new HashMap<>();

    public int numSquares(int n) {
        if(n==0)return 0;
        if(n<0)return Integer.MAX_VALUE;
        if(map.containsKey(n))return map.get(n);
        int minCount = Integer.MAX_VALUE;
        for(int i=1;i*i<=n;i++){
           int count = numSquares(n-i*i);
           if(count!=Integer.MAX_VALUE) minCount = Math.min(minCount,count+1);
        }
        map.put(n,minCount);
        return minCount;
    }
}