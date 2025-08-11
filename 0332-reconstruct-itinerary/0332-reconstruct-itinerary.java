class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        
        // tickets.sort((t1, t2)->
        //         t1.get(0).equals(t2.get(0)) ? 
        //         t1.get(1).compareTo(t2.get(1)) : 
        //         t1.get(0).compareTo(t2.get(0))
        //         );
        Map<String, PriorityQueue<String>> adjListMap = new HashMap();
        for (List<String> ticket : tickets) {
            adjListMap.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).add(ticket.get(1));
        }
        Stack<String> stack = new Stack<>();
        List<String> res = new ArrayList();
        stack.push("JFK");
        Set<String> visited = new HashSet();
        // while(!stack.isEmpty()){
        //     String ticket = stack.pop();
        //     res.add(ticket);
        //     PriorityQueue<String> queue = adjListMap.get(ticket);
        //     while(queue!=null && !queue.isEmpty()){
        //         stack.push(queue.poll());
        //     }
        // }
        dfs("JFK",adjListMap,res);
        return res;
    }
    public void dfs(String airport, Map<String, PriorityQueue<String>> adjListMap, List<String> res){
        PriorityQueue<String> queue = adjListMap.get(airport);
        while(queue!=null && !queue.isEmpty()){
            dfs(queue.poll(),adjListMap,res);
        }
        res.addFirst(airport);
    }
}




