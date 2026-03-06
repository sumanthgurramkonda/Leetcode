/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root==null)return null;
        Node left = root.left;
        Node right = root.right;
        if(left!=null){
            left.next = right;
        }
        if(right!=null){
            if(root.next!=null){
                if(root.next.left!=null){
                    right.next = root.next.left;
                }else{
                    right.next = root.next.right;
                }
            }
        }else if(left!=null){
            if(root.next!=null){
                if(root.next.left!=null){
                    left.next = root.next.left;
                }else{
                    left.next = root.next.right;
                }
            }
        }

        connect(root.left);
        connect(root.right);
        
        return root;
    }
}