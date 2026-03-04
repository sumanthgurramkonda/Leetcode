class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {

        int n = triangle.size();
        if(n==1) return triangle.get(0).get(0);
        int[] arr = new int[n];
        for(int i=0;i<n;i++) arr[i] = triangle.get(n-1).get(i);
        for(int i=n-2;i>=0;i--){
            List<Integer> currentList = triangle.get(i);
            for(int j=0;j<=i;j++){
                arr[j] = currentList.get(j)+Math.min(arr[j], arr[j+1]);
            }
        }
        return arr[0];
    }

    // public int dfs(List<List<Integer>> triangle, int index){
    //     if(n==triangle.size()-1)return 0;
    //     List<Integer> list = triangle.get(index);
    //     int min = Integer.MAX_VALUE;
    //     for(int i=0;i<list.size();i++){
    //         List<Integer> childList = triangle.get(index);
    //         int sum = dfs(triangle, index+1);
    //     }
    //     return min;
    // }
}