class Solution {
    public int findCenter(int[][] edges) {
        int len = edges.length;
        int[] nodeCount = new int[len+1];
        int maxCount = 0, maxNode = -1;
        for(int[] edge : edges){
            int count1 = nodeCount[edge[0]-1]++;
            int count2 = nodeCount[edge[1]-1]++;
            if(count1>maxCount){
                maxCount = count1;
                maxNode = edge[0];
            }
            if(count2>maxCount){
                maxCount = count2;
                maxNode = edge[1];
            }
        }
        return maxNode;
    }
}