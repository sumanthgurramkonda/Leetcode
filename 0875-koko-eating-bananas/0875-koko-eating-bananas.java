class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int len = piles.length;
        int total=0,min=1,max=0;

        for(int pile : piles){
            total += pile;
            max = Math.max(max, pile);
        }
        while(min<max){
            int mid = (min+max)/2;
            int time = getHours(piles, mid);
            if(time<=h){
                max = mid;
            }else{
                min = mid+1;
            }
        }
        return min;
    }

    public int getHours(int[] piles, int eableBananas){
        int time = 0;
        for(int pile : piles){
            time += (pile/eableBananas);
            if((pile%eableBananas)!=0) time+=1;
        }
        return time;
    }
}

/*
total = 27
min = 3
max = 11;
h = 8

*/