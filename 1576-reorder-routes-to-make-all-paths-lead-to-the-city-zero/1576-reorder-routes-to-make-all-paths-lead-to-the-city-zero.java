class Solution {

    Map<Integer, List<Integer>> adjListMap = new HashMap();
    Map<Integer, Set<Integer>> connectionMap = new HashMap();
    public int minReorder(int n, int[][] connections) {
        
        for(int[]connection : connections){
            adjListMap.putIfAbsent(connection[0],new LinkedList());
            adjListMap.get(connection[0]).add(connection[1]);
            adjListMap.putIfAbsent(connection[1],new LinkedList());
            adjListMap.get(connection[1]).add(connection[0]);
            connectionMap.putIfAbsent(connection[0],new HashSet());
            connectionMap.get(connection[0]).add(connection[1]);
        }
        
        visited.add(0);
        dfs(0);
        // for(int[]connection : connections) dfs(connection[0]);
        return count;
    }
    int count=0;
    Set<Integer> visited = new HashSet();
    public void dfs(int n){
        if(!adjListMap.containsKey(n))return;
        for(int node : adjListMap.get(n)){
            if(visited.contains(node)) continue;
            if(connectionMap.containsKey(n) && 
                connectionMap.get(n).contains(node))count+=1;
            visited.add(node);  
            dfs(node);
        }
    }
}




  