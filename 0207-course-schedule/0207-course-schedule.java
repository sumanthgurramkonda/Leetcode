class Solution {
    Map<Integer, List<Integer>> map = new HashMap();
    boolean[] memo;
    boolean[] visited;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length==0)return true;
        memo = new boolean[numCourses];
        visited = new boolean[numCourses];
        for(int i=0;i<prerequisites.length;i++){
            int l = prerequisites[i][0];
            int r = prerequisites[i][1];
            List<Integer> list;
            if(map.containsKey(l)){
                map.get(l).add(r);
            }else{
                list = new ArrayList();
                list.add(r);
                map.put(l, list);
            }
        }

        for(int i=1;i<numCourses;i++){
            if(dfs(i)) return false;
        }
        return true;
    }

    public boolean dfs(int num){
        if(memo[num]) return true;
        if(visited[num])return false;
        if(!map.containsKey(num))return false;
        List<Integer> list = map.get(num);
        if(list==null || list.size()==0)return false;
        memo[num]=true;
        visited[num]=true;
        for(int n : list){
            if(dfs(n)) return true;;
        }
        memo[num]=false;
        return false;
    }
}