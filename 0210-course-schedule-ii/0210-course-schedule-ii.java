class Solution {
    Map<Integer, List<Integer>> adjList =new HashMap();
    boolean[] visited;
    boolean[] path;
    // List<Integer> res = new LinkedList();
    Set<Integer> res = new LinkedHashSet();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(prerequisites.length==0){
            int[] res = new int[numCourses];
            for(int i=0;i<numCourses;i++){
                res[i]=numCourses-1;
                numCourses-=1;
            }
            return res;
        }
        path = new boolean[numCourses];
        visited = new boolean[numCourses];

        for(int i=0;i<prerequisites.length;i++){
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];
            if(adjList.containsKey(a)){
                adjList.get(a).add(b);
            }else{
                List<Integer> list = new ArrayList();
                list.add(b);
                adjList.put(a,list);
            }
        }
        boolean isVisited= false;
        for(int i=0;i<numCourses;i++){
            if(dfs(i)) {
                return new int[0];
            }
            else res.add(i);
        }
        int[] resArray = new int[res.size()];
        // for(int i=0;i<res.size();i++) resArray[i]=res.get(i);
        int i = 0;
        for(int n : res){
            resArray[i++]=n;
        }
        return resArray;
    }

    public boolean dfs(int node){
        if(path[node]) return true;
        if(visited[node])return false;
        List<Integer> list = adjList.get(node);
        if(list==null || list.size()==0)return false;
        visited[node] = true;
        path[node]=true;
        for(int n : list){
            if(dfs(n)){
                return true;
            }else{
                res.add(n);
            }
        }
        path[node]=false;
        return false;
    }
}




