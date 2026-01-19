class Solution {
    public int twoCitySchedCost(int[][] costs) {
         int minSum = 0;

         Arrays.sort(costs,Comparator.comparingInt(c->c[0]-c[1]));

         for(int i=0;i<costs.length;i++){
            if(i<costs.length/2) minSum += costs[i][0];
            else minSum += costs[i][1];
         }

         return minSum;

    }
}


