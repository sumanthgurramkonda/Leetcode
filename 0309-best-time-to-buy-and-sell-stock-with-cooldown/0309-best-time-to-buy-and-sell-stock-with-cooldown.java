class Solution {

    Map<Integer, Map<Boolean, Integer>> memo = new HashMap();
    public int maxProfit(int[] prices) {
        if(prices.length==1)return 0;
        return maxProfit(prices,0,true);
    }

    public int maxProfit(int[] prices, int i, boolean b){
        if(i>=prices.length) return 0;
        if(memo.containsKey(i)){
           Map<Boolean, Integer> map = memo.get(i);
           if(map.containsKey(b)){
              return map.get(b);
           }
        }
        int buy = 0, sell=0, coolDown = 0;
        Map<Boolean, Integer> map = new HashMap();
        if(b){
           buy = maxProfit(prices,i+1,!b)-prices[i];
           coolDown = maxProfit(prices,i+1,b);
           map.put(b, Math.max(buy,coolDown));
        }else{
           sell = maxProfit(prices,i+2,!b)+prices[i];
           coolDown = maxProfit(prices,i+1,b);
           map.put(b, Math.max(sell,coolDown));
        }
        memo.put(i, map);
        return memo.get(i).get(b);
        // return Math.max(buy,Math.max(sell,coolDown));
    }
}

   

