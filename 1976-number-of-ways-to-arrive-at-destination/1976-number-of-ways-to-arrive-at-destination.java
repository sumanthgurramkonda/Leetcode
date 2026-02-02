class Solution {

    class Pair{
        int node;
        long time;

        public Pair(int node, long time){
            this.node = node;
            this.time = time;
        }
    }

    public int countPaths(int n, int[][] roads) {

        List<List<Pair>> roadsList = new ArrayList(n);

        for(int i=0;i<n;i++){
            roadsList.add(new ArrayList(n));
        }

        for(int i=0;i<roads.length;i++){
            List<Pair> pair = roadsList.get(roads[i][0]);
            pair.add(new Pair(roads[i][1], roads[i][2]));

            pair = roadsList.get(roads[i][1]);
            pair.add(new Pair(roads[i][0], roads[i][2]));
        }
        int MOD = 1000000007;
        long[] times = new long[n];
        long[] counts = new long[n];
        Arrays.fill(times, Long.MAX_VALUE);
        times[0]=0;
        counts[0]=1;

        PriorityQueue<Pair> queue = new PriorityQueue<>((a,b)->Long.compare(a.time, b.time));
        queue.add(new Pair(0,0));

        while(!queue.isEmpty()){

            Pair pair = queue.poll();
            int node = pair.node;
            long time = pair.time;
            if(time > times[node]) continue;
            List<Pair> nodes = roadsList.get(node);

            for(Pair p : nodes){
                long newTime = time + p.time;

                if(newTime < times[p.node]){
                    times[p.node] = newTime;
                    counts[p.node] = counts[node];
                    queue.add(new Pair(p.node, newTime));
                }else if(newTime == times[p.node]){
                    counts[p.node] = (counts[p.node]+counts[node])%MOD;
                }
            }
        }
        
        return (int)counts[n-1];
    }

    
}

