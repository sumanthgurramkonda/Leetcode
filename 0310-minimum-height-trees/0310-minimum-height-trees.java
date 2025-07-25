class Solution {

    Map<Integer, Set<Integer>> adjListMap = new HashMap();
    // Map<Integer, List<Integer>> adjListMap = new HashMap();
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(edges.length==0){
            List<Integer> list = new ArrayList();
            for(int i=0;i<n;i++)list.add(i);
            return list;
        }
        int[] heights = new int[n];
        Arrays.fill(heights,-1);
        int min = Integer.MAX_VALUE;
        for(int[] edge : edges){
                adjListMap.putIfAbsent(edge[0],new HashSet());
                adjListMap.putIfAbsent(edge[1],new HashSet());
                // adjListMap.putIfAbsent(edge[0],new ArrayList());
                // adjListMap.putIfAbsent(edge[1],new ArrayList());
                adjListMap.get(edge[0]).add(edge[1]);
                adjListMap.get(edge[1]).add(edge[0]);
        }
        // for(int i=0;i<n;i++){
        //     heights[i]=findHeight(edges,heights,i);
        //     min = Math.min(min,heights[i]);
        // }
        // List<Integer> res = new ArrayList();
        // for(int i=0;i<n;i++){
        //     if(heights[i]==min) res.add(i);
        // }
        return findNodes(n);
    }
    public List<Integer> findNodes(int n){
        List<Integer> leafNodes = new ArrayList();
        for(int i=0;i<n;i++){
            if(adjListMap.getOrDefault(i,new HashSet()).size()==1){
                leafNodes.add(i);
            }
        }
        int totalNodes = n;
        while(totalNodes>2){
            totalNodes -= leafNodes.size();
            List<Integer> newLeafNodes = new ArrayList();
            // Set<Integer> visited = new HashSet();
            for(int node : leafNodes){
                if(adjListMap.get(node).size()>0){
                    int neighbour = adjListMap.get(node).iterator().next();
                    adjListMap.get(neighbour).remove(node);
                    if(adjListMap.get(neighbour).size()==1){
                        newLeafNodes.add(neighbour);
                    }
                    // visited.add(neighbour);
                }
            }
            leafNodes = newLeafNodes;
        }
        return leafNodes;
    }


    // Set<Integer> visited = new HashSet();
    // public int findHeight(int[][] edges, int[] heights,int node){
    //     if(visited.contains(node))return 0;
    //     visited.add(node);
    //     int max = 0;
    //     for (int child : adjListMap.getOrDefault(node, new ArrayList<>())) {
    //        max = Math.max(max, findHeight(edges, heights, child));
    //     }
    //     visited.remove(node);
    //     return max+1;
    // }
}

