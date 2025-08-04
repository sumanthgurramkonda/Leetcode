class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        Set<Integer> visited = new HashSet();
        Queue<int[]> queue = new PriorityQueue<>((a,b)->a[0]-b[0]);
        queue.offer(new int[]{0,0});  // cost, edge poin
        int minCost = 0;
        while(visited.size()<n){
            int[] arr = queue.poll();
            int i = arr[1];
            if(visited.contains(i)) continue;
            visited.add(i);
            minCost += arr[0];

            for(int j=0;j<n;j++){
                if(visited.contains(j))continue;
                int cost = Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
                queue.offer(new int[]{cost,j});
                queue.offer(new int[]{cost,i});
            }
        }
        return minCost;
    }
}