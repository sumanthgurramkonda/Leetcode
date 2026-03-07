/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {

    Map<Node, Node> nodeMap = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(nodeMap.containsKey(node) || node==null)return nodeMap.getOrDefault(node,null);
        ArrayList<Node> neighbors = new ArrayList<>();
        Node newNode = new Node(node.val, neighbors);
        nodeMap.put(node,newNode);
        for(Node neighbor : node.neighbors){
            Node n = cloneGraph(neighbor);
            if(n!=null)neighbors.add(n);
        }
        return newNode;
    }
}