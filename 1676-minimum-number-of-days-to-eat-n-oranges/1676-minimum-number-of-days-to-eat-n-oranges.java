class Solution {
    static Map<Integer,Integer> cache = new HashMap();
    public int minDays(int n) {

        return minDays2(n);
    }

    public int minDays2(int n){
        if(n<=2)return n;
        if(cache.containsKey(n))return cache.get(n);

        int two = n%2+minDays2(n/2);
        int three = n%3+minDays2(n/3);
        int min = 1+Math.min(two,three);
        cache.put(n,min);
        return min;
    }

    public int minDays1(int n){
        if(n<=0)return 0;
        if(cache.containsKey(n)) return cache.get(n);
        int one=Integer.MAX_VALUE;
        int two=Integer.MAX_VALUE;
        int three = Integer.MAX_VALUE;
        if(n%3==0){
            three = minDays1(n-(2*(n/3)));
        }
        if(n%2==0){
            two = minDays1(n-(n/2));
        }
        if(n%2!=0 || n%3!=0)one = minDays1(n-1);
        int min = Math.min(one,Math.min(two,three));
        int num = 1+(min ==Integer.MAX_VALUE ? 0 : min);
        cache.put(n,num);
        return num;
    }
}