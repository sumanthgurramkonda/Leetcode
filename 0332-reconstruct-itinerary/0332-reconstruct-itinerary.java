class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        
        Map<String, PriorityQueue<String>> adjListMap = new HashMap();
        for (List<String> ticket : tickets) {
            adjListMap.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).add(ticket.get(1));
        }
        List<String> res = new LinkedList();
        Set<String> visited = new HashSet();
        dfs("JFK",adjListMap,res);
        return res;
    }
    public void dfs(String airport, Map<String, PriorityQueue<String>> adjListMap, List<String> res){
        PriorityQueue<String> queue = adjListMap.get(airport);
        // res.add(airport);
        while(queue!=null && !queue.isEmpty()){
            dfs(queue.poll(),adjListMap,res);
        }
        res.addFirst(airport);
    }
}




