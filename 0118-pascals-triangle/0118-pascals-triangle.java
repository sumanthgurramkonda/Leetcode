class Solution {
    public List<List<Integer>> generate(int numRows) {
     return generatePT(numRows);   
    }


    public List<List<Integer>> generatePT(int n){

        List<List<Integer>> res = new ArrayList(n);
        if(n==0)return res;
        List<Integer> list = new ArrayList();
        list.add(1);
        res.add(list);
        for(int i=2;i<=n;i++){
            List<Integer> prevList = list;
            list = new ArrayList();
            list.add(1);
            for(int j=0;j<prevList.size()-1;j++){
                list.add(prevList.get(j)+prevList.get(j+1));
            }
            list.add(1);
            res.add(list);
        }
        return res;
    }
}