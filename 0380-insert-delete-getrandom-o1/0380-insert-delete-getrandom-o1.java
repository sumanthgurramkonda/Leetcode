class RandomizedSet {
    private HashMap<Integer, Integer> map;
    private List<Integer> list;
    private int index = 0;
    public RandomizedSet() {
        map = new HashMap();
        list = new ArrayList();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val))return false;
        map.put(val, index);
        list.add(val);
        index++;
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val))return false;
        int currIndex = map.get(val);
        int lastValue = list.get(index-1);
        list.set(currIndex, lastValue);
        list.remove(index-1);
        map.put(lastValue, currIndex);
        map.remove(val);
        index-=1;
        return true;
    }  
    
    public int getRandom() {
        int index = (int) (Math.random()*list.size());
        return list.get(index);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */