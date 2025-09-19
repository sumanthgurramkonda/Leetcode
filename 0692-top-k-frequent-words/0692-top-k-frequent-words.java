class Solution {

    class Pair{
        public String word;
        public int count;
        public Pair(String word, int count){
            this.word = word;
            this.count = count;
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        
        Map<String, Pair> map = new HashMap();
        for(String word : words){
           if(map.containsKey(word)){
             map.get(word).count++;
           }else{
            Pair pair = new Pair(word,1);
            map.put(word,pair);
           }
        }
        Queue<Pair> queue = new PriorityQueue<>((a,b)->{
            if(b.count==a.count) return a.word.compareTo(b.word);
            return b.count-a.count;
        });
        for(Pair p : map.values()){
            queue.add(p);
        }
        List<String> res = new LinkedList();
        while (res.size() < k && !queue.isEmpty()) {
            res.add(queue.poll().word);
        }
        return res;
    }
}

