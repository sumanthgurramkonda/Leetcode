class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        boolean[] visited = new boolean[rooms.size()];
        visited[0] = true;
        dfs(rooms,visited,rooms.get(0));
        for(int i=1;i<rooms.size();i++)if(!visited[i])return false;
        return true;
    }


    public void dfs(List<List<Integer>> rooms, boolean[] visited, List<Integer> locks){

        for(int i=0;i<locks.size();i++){
            int lock = locks.get(i);
            if(visited[lock]) continue;
            visited[lock] = true;
            dfs(rooms, visited, rooms.get(lock));
        }
    }
}