class Solution {
    
    public int kthSmallest(int[][] matrix, int k) {
        return kthSmallestElement(matrix,k);
    }

    public int kthSmallestElement(int[][] matrix, int k){
        Queue<Integer> queue = new PriorityQueue(Collections.reverseOrder());

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(queue.size()<k){
                    queue.add(matrix[i][j]);
                }else if(queue.peek()>matrix[i][j]){
                    queue.poll();
                    queue.add(matrix[i][j]);
                }
            }
        }
        return queue.poll();
    }
}