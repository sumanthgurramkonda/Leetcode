class Solution {
    boolean[] visited;
    Map<Integer,List<Integer>> adjListMap = new HashMap<>();
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {

        for(int i=0;i<n;i++){
            int index = manager[i];
            if(index==-1)index=headID;
            adjListMap.putIfAbsent(index,new ArrayList());
            adjListMap.get(index).add(i);
        }
        visited = new boolean[n];
        return numOfMinutes1(n,headID,manager,informTime);
    }

    public int numOfMinutes1(int n,int id, int[] manager, int[] informTime){
        if(visited[id])return 0;
        int maxTime = 0;
        visited[id]=true;
        List<Integer> list = adjListMap.getOrDefault(id,new ArrayList());
        for(int node : list){
            int currentTime = numOfMinutes1(n,node,manager,informTime)+informTime[id];
            maxTime = Math.max(currentTime,maxTime);
        }
        visited[id]=false;

        return maxTime;
    }  
}

