class Solution {
    Map<Integer, List<Integer>> adjList = new HashMap();
    Set<Integer> visited = new HashSet();
    List<List<Integer>> resList = new ArrayList();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        for(int i=0;i<n;i++){
            List<Integer> list = new ArrayList();
            for(int j=0;j<graph[i].length;j++){
                list.add(graph[i][j]);
            }
            adjList.put(i,list);
        }
        findPaths(0,n-1,new ArrayList(),0);
        return resList;
    }

    public void findPaths(int currentNode, int endNode, List<Integer> list,int index){

        if(currentNode==endNode){
            List<Integer> newList = new ArrayList(list);
            newList.add(endNode);
            resList.add(newList);
            return;
        }
        if(visited.contains(currentNode))return;
        visited.add(currentNode);
        list.add(index,currentNode);
        for(int node : adjList.get(currentNode)){
            findPaths(node,endNode,list,index+1);
        }
        list.remove(index);
        visited.remove(currentNode);

    }

}  

