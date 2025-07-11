class Solution {

    Map<Integer, List<Integer>> graph;
    Set<Integer> memo = new HashSet();
    public boolean validPath(int n, int[][] edges, int source, int destination) {

        graph = new HashMap();

        for(int i=0;i<edges.length;i++){
            int u = edges[i][0], v = edges[i][1];
            List<Integer> list;
            if(graph.containsKey(u)){
                graph.get(u).add(v);
            }else{
                list = new ArrayList();
                list.add(v);
                graph.put(u,list);
            }
            if(graph.containsKey(v)){
                graph.get(v).add(u);
            }
            else{
                list = new ArrayList();
                list.add(u);
                graph.put(v,list);
            }
        }
        return validPath(source,destination);

    }

    public boolean validPath(int source, int destination){

        List<Integer> list = graph.get(source);
        if(!memo.add(source)) return false;
        if(source==destination)return true;
        for(int num : list){
            if(validPath(num,destination)){
                return true;
            }
        }
        return false;
    }

}