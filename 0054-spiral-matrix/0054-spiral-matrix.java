class Solution {

    public List<Integer> spiralOrder(int[][] matrix) {

        int top=0, down=matrix.length-1;
        int left = 0, right=matrix[0].length-1;
        List<Integer> list = new ArrayList();
        int count=(down+1) * (right+1);
        while(left<=right && top<=down){
            
            for(int i=left;i<=right && list.size()<count;i++){
                list.add(matrix[top][i]);
            }
            top++;
            for(int i=top;i<=down && list.size()<count;i++){
                list.add(matrix[i][right]);
            }
            right--;
            for(int i=right;i>=left && list.size()<count;i--){
                list.add(matrix[down][i]);
            }
            down--;
            for(int i=down;i>=top && list.size()<count;i--){
                list.add(matrix[i][left]);
            }
            left++;
        }
        return list;
    }
}

