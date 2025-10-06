class Solution {
    public int[][] kClosest(int[][] points, int k) {
        if(k==points.length)return points;
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->b[0]-a[0]);

        for(int[] point : points){
            int x = Math.abs(point[0]);
            int y = Math.abs(point[1]);
            int dist = (x*x) + (y*y);
            if(queue.size()==k){
                if(dist<queue.peek()[0]){
                    queue.poll();
                    queue.add(new int[]{dist,point[0],point[1]});
                }
            }else{
                queue.add(new int[]{dist,point[0],point[1]});
            }
        }
        Iterator itr = queue.iterator();
        int[][] res = new int[k][2];
        while(itr.hasNext()){
            k--;
            int[] arr = (int[])itr.next();
            res[k][0] = arr[1];
            res[k][1] = arr[2];
        }
        return res;
    }
}