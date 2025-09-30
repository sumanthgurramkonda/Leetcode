class StockPrice {

    private TreeMap<Integer, Integer> stockPrice;
    private Map<Integer, Integer> timestamps;
    private int latestTimestamp = 0;

    public StockPrice() {
        stockPrice = new TreeMap<>();
        timestamps = new HashMap<>();
    }
    
    public void update(int timestamp, int price) {
        if(timestamps.containsKey(timestamp)){
            int p = timestamps.get(timestamp);
            stockPrice.put(p, stockPrice.get(p)-1);
            if(stockPrice.get(p)==0){
                stockPrice.remove(p);
            }
        }
        timestamps.put(timestamp, price);
        stockPrice.put(price,stockPrice.getOrDefault(price,0)+1);
        latestTimestamp = Math.max(latestTimestamp, timestamp);
    }
    
    public int current() {
        return timestamps.get(latestTimestamp);
    }
    
    public int maximum() {
       return !stockPrice.isEmpty() ? stockPrice.lastKey() : 0 ;
    }
    
    public int minimum() {
       return !stockPrice.isEmpty() ? stockPrice.firstKey() : 0;
    }

}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */