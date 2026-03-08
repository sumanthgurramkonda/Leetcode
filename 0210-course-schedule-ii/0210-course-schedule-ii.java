class Solution {
    Map<Integer, List<Integer>> adjList = new HashMap<>();
    boolean[] visited;
    boolean[] path;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(numCourses==0)return null;
        if(prerequisites.length==0){
            int[] arr = new int[numCourses];
            for(int i=0;i<prerequisites.length;i++){
                arr[i] = prerequisites.length-i-1;
                return arr;
            }
        }
        visited = new boolean[numCourses];
        path = new boolean[numCourses];
        for(int i=0;i<numCourses;i++){
            adjList.put(i, new ArrayList<>());
        }
        for(int[] arr : prerequisites){
            adjList.get(arr[0]).add(arr[1]);
        }
        for(int i=0;i<numCourses;i++){
            if(dfs(i))return new int[0];
        }

        if(res.size()<numCourses)return null;
        return res.stream().mapToInt(c -> c).toArray();
    }

    List<Integer> res = new ArrayList<>();
    
    public boolean dfs(int node){
        if(path[node])return true;
        if(visited[node])return false;
        path[node]=true;
        visited[node]=true;
        for(int n : adjList.get(node)){
            if(dfs(n)) return true;
        }
        res.add(node);
        path[node]=false;
        return false;
    }
}