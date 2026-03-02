class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] pair = new int[n][2];

        for(int i=0;i<n;i++){
            pair[i][0] = efficiency[i];
            pair[i][1] = speed[i];
        }
        Arrays.sort(pair,(a,b)->Integer.compare(b[0], a[0]));
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
       
        long maxPerformace = 0;
        long sum = 0;
        int MOD = 1_000_000_007;
        for(int i=0;i<n;i++){
            if(minQueue.size()==k){
                sum -= minQueue.poll();;
            }
            minQueue.add(pair[i][1]);
            sum += pair[i][1];
            long performance = sum * pair[i][0]; 
            maxPerformace = Math.max(maxPerformace, performance);
        }
        
        return (int)(maxPerformace%MOD);
    }
}