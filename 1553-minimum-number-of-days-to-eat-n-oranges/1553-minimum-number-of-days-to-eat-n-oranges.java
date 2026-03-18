class Solution {

    Map<Integer, Integer> memo = new HashMap<>();

    public int minDays(int n) {
        if(n<=0)return 0;
        if(n==1)return 1;
        if(memo.containsKey(n)) return memo.get(n);
        int daysCount = Integer.MAX_VALUE;
    
        if(n%2==0){
            int eatableOranges = (n/2);
            daysCount = Math.min(daysCount,minDays(n-eatableOranges));
        }
        if(n%3==0){
            int eatableOranges = 2*(n/3);
            daysCount = Math.min(daysCount,minDays(n-eatableOranges));
        }
        if(n%2!=0 || n%3!=0)  daysCount = Math.min(daysCount,minDays(n-1));

        if(daysCount!=Integer.MAX_VALUE) daysCount+=1;
        memo.put(n,daysCount);
        return daysCount;
    }
}