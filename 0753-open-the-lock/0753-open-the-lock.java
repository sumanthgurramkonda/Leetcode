class Solution {
    
    public int openLock(String[] deadends, String target) {
        if("0000".equals(target))return 0;

        return openLockCount(deadends,target);
        
    }

    public int openLockCount(String[] deadends,String target){
        Queue<String> queue = new LinkedList();
        Set<String> set = new HashSet();
        for(String deadend : deadends)set.add(deadend);
        if(set.contains("0000"))return -1;
        queue.offer("0000");
        int turns = 0;
        while(!queue.isEmpty()){
            
            int size = queue.size();
            turns+=1;
            while(size--!=0){
                String lock = queue.poll();
                for(int i=0;i<4;i++){
                    char c = lock.charAt(i);
                    char up = turnWheel(c,true);
                    char down = turnWheel(c,false);
                    String lock1 = lock.substring(0,i)+up+lock.substring(i+1,4);
                    String lock2 = lock.substring(0,i)+down+lock.substring(i+1,4); 
                    if(lock1.equals(target) || lock2.equals(target)) return turns;
                    if(!set.contains(lock1)){
                        queue.offer(lock1);
                        set.add(lock1);
                    }
                    if(!set.contains(lock2)){
                        queue.offer(lock2); 
                        set.add(lock2);
                    }
                }
            }
        }
        return -1;
    }

    public char turnWheel(char c , boolean isUp){
       if(c=='0') return isUp ? '9' : '1';
       if(c=='9') return isUp ? '8' : '8';
       return (char)(isUp ? c-1 : c+1);
    }

}

