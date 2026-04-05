class Solution {

    class Node{
        int node;
        int price;
        int k;
        public Node(int node, int price, int k){
            this.node = node;
            this.price = price; 
            this.k=k;
        }
    }

    Map<Integer, List<Node>> graph = new HashMap<>();

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        for(int i=0;i<n;i++){
            graph.put(i, new ArrayList<>());
        }
        for(int[] flight : flights){
            int from = flight[0];
            int to = flight[1];
            int price = flight[2];
            graph.get(from).add(new Node(to, price,0));
        }

        return findCheapestPrice(n,src, dst, k);

    }

    public int findCheapestPrice(int n, int src, int dst, int k){

        PriorityQueue<Node> pq = new PriorityQueue<>((n1,n2)->Integer.compare(n1.price, n2.price));
        pq.add(new Node(src,0,0));

        int[] minStops = new int[n];
        Arrays.fill(minStops, Integer.MAX_VALUE);

        while(!pq.isEmpty()){
            Node curr = pq.poll();
            if(curr.node==dst){
                return curr.price;
            }
            if(curr.k==k+1 || curr.k>=minStops[curr.node])continue;
            minStops[curr.node]=curr.k;
            for(Node node : graph.get(curr.node)){
                int nextNode = node.node;
                int nextPrice = curr.price+node.price;
                pq.add(new Node(nextNode, nextPrice, curr.k+1));
            }
        }
        return -1;
    }
}
