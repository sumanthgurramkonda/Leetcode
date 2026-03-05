class LockingTree {

    private int[] parent;
    private List<Integer>[] children;
    private Map<Integer, Integer> locked = new HashMap<>();

    public LockingTree(int[] parent) {
        this.parent = parent;
        this.children = new ArrayList[parent.length];
        for(int i=0;i<parent.length;i++)children[i] = new ArrayList();
        for(int i=1;i<parent.length;i++){
            children[parent[i]].add(i);
        }
    }
    
    public boolean lock(int num, int user) {
        if(locked.containsKey(num)) return false;
        locked.put(num, user);
        return true;
    }
    
    public boolean unlock(int num, int user) {
        if(locked.getOrDefault(num, -1)!=user)return false;
        locked.remove(num);
        return true;
    }
    
    public boolean upgrade(int num, int user) {
        if(locked.containsKey(num))return false;
        int curr = parent[num];
        while(curr!=-1){
            if(locked.containsKey(curr)) return false;
            curr=parent[curr];
        }

        List<Integer> lockedNodes = new ArrayList<>();
        dfs(num,lockedNodes);
        if(lockedNodes.size()==0)return false;
        for(int node : lockedNodes) locked.remove(node);
        locked.put(num, user);
        return true;
    }

    public void dfs(int node, List<Integer> lockedNodes){
        for(int currentNode : children[node]){
            if(locked.containsKey(currentNode)) lockedNodes.add(currentNode);
            dfs(currentNode, lockedNodes);
        }
    }
}

/**
 * Your LockingTree object will be instantiated and called as such:
 * LockingTree obj = new LockingTree(parent);
 * boolean param_1 = obj.lock(num,user);
 * boolean param_2 = obj.unlock(num,user);
 * boolean param_3 = obj.upgrade(num,user);
 */