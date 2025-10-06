class Solution {

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
          int n = profits.length;
          PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->a[0]-b[0]);

          for(int i=0;i<n;i++){
            int[] arr = new int[2];
            arr[0] = capital[i];
            arr[1] = profits[i];
            queue.add(arr);
          }
          PriorityQueue<Integer> maxProfitQueue = new PriorityQueue<>(Collections.reverseOrder());
          while(k>0){
            while(!queue.isEmpty() && w>=queue.peek()[0]){
                maxProfitQueue.add(queue.poll()[1]);
            }
            if(!maxProfitQueue.isEmpty()) w+=maxProfitQueue.poll();
            k--;
          }
          return w;

        //   return findMaximizedCapital1(int k, int w, int[] profits, int[] capital);
    }
    
    // O(n * k)
    public int findMaximizedCapital1(int k, int w, int[] profits, int[] capital) {
          int n = profits.length;
          Map<Integer,PriorityQueue<Integer>> map = new HashMap<>();
          for(int i=0;i<n;i++){
            if(!map.containsKey(capital[i])){
                PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
                queue.add(profits[i]);
                map.put(capital[i], queue);
            }else{
                map.get(capital[i]).add(profits[i]);
            }
          }
          int currentCapital = w;
          Set<Integer> set = new HashSet();
          for(int i=0;i<n;i++){
            set.add(capital[i]);
          }
          while(k>0){
            int maxProfit = -1;
            int currentCap = -1;
            Iterator itr = set.iterator();
            while(itr.hasNext()){
                int cap = (int)itr.next();
                PriorityQueue<Integer> queue = map.getOrDefault(cap,new PriorityQueue<>());
                if(!queue.isEmpty() && cap<=currentCapital){
                    if(queue.peek()>maxProfit){
                        maxProfit = queue.peek();
                        currentCap = cap;
                    }
                }
            }
            // for(int cap=0;cap<=currentCapital;cap++){
            //     PriorityQueue<Integer> queue = map.getOrDefault(cap,new PriorityQueue<>());
            //     if(!queue.isEmpty()){
            //         if(queue.peek()>maxProfit){
            //             maxProfit = queue.peek();
            //             currentCap = cap;
            //         }
            //     }
            // }
            if(currentCap==-1) return currentCapital;
            currentCapital += map.get(currentCap).poll();
            if(map.get(currentCap).isEmpty()){
                map.remove(currentCap);
                set.remove(currentCap);
            }
            k--;
          }

          return currentCapital;
    }

}




