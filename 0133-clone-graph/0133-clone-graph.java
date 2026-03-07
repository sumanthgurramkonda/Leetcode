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
    Map<Node, Node> memo = new HashMap();
    public Node cloneGraph(Node node) {
        if(node==null)return null;
        Node root = new Node();
        root.val = node.val;
        cloneGraph1(node, root);
        return root;
    }

    public void cloneGraph1(Node node,Node newNode){
        memo.put(node,newNode);
        List<Node> list = new LinkedList();
        List<Node> neighbors = node.neighbors;
        newNode.neighbors = list;
        for(Node n : neighbors){
            Node node1 = new Node();
            node1.val = n.val;
            if(memo.containsKey(n)){
                list.add(memo.get(n));
            }
            else {
                list.add(node1);
                cloneGraph1(n, node1);
            }
        }
    }




}