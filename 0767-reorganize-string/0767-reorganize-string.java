class Solution {

    class Pair implements Comparable<Pair>{
        char c;
        int count;
        public Pair(char c, int count){
            this.c=c;
            this.count=count;
        }

        @Override
        public int compareTo(Pair pair){
            return Integer.compare(this.count, pair.count);
        }

    }
    public String reorganizeString(String s) {
        PriorityQueue<Pair> queue = new PriorityQueue<>((p1,p2)->p2.count-p1.count);
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            queue.add(new Pair(entry.getKey(), entry.getValue()));
        }
        StringBuilder str = new StringBuilder();

        while(!queue.isEmpty()){
            Pair p1 = queue.poll();
            if(queue.isEmpty()){
                if(p1.count!=0)str.append(p1.c);
                p1.count--;
                if(str.length()!=s.length())return "";
                break;
            }
            Pair p2 = queue.poll();
            if(p1.count>0){
                str.append(p1.c);
                p1.count--;
                queue.add(p1);
            }
            if(p2.count>0){
                str.append(p2.c);
                p2.count--;
                queue.add(p2);
            }
        }
        for(int i=0;i<str.length()-1;i++){
            if(str.charAt(i)==str.charAt(i+1))return "";
        }
        return str.toString();
    }
}




