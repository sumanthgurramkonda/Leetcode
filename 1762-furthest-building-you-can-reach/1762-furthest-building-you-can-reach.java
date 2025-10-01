class Solution {
    int[][][] dp ;
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        // dp = new int[heights.length][bricks+1][ladders+1];
        // for(int[][] arr : dp){
        //     for(int[]ar : arr){
        //         Arrays.fill(ar,-1);
        //     }
        // }
        // return dfs(heights,bricks,ladders,0);
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<heights.length-1;i++){
            int diff = heights[i+1]-heights[i];
            if(diff<=0)continue;
            bricks-=diff;
            queue.add(diff);
            if(bricks<0){
                if(ladders==0)return i;
                ladders-=1;
                bricks += queue.poll();
            } 
        }
        return heights.length-1;
    }

    public int dfs(int[] heights, int bricks, int ladders, int index){
        if(index==heights.length-1) return index;
        // if(dp[index][bricks][ladders]!=-1)return dp[index][bricks][ladders];
        int diff = heights[index+1]-heights[index];

        if(diff<=0){
            return dfs(heights, bricks, ladders, index+1);
        }
        int reachableBrick = -1, reachableLadder = -1;

        if(bricks>=diff){
            reachableBrick = dfs(heights, bricks-diff, ladders, index+1);
        }
        if(ladders>0){  
            reachableLadder = dfs(heights, bricks, ladders-1, index+1);
        }
        if(reachableBrick==-1 && reachableLadder==-1)return index;
        return Math.max(reachableBrick,reachableLadder);
    } 

}

