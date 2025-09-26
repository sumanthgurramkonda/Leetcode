/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {

    TreeNode root;
    // Queue<Integer> queue = new LinkedList<>();
    Stack<TreeNode> stack = new Stack<>();
    public BSTIterator(TreeNode root) {
        this.root = root;
        if(root!=null)stack.push(root);
        // dfs(root);
    }
    
    public int next() {
        // return queue.poll();
        return linearDFS();
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public int linearDFS(){
        TreeNode node = stack.peek();
        TreeNode prevNode = node;
        while(node.left!=null){
            stack.push(node.left);
            prevNode = node;
            node = node.left;
            prevNode.left=null;
        }
        node = stack.pop();
        if(node.right!=null)stack.push(node.right);
        return node.val;
    }

    // public void dfs(TreeNode root){
    //     if(root==null)return;
    //     dfs(root.left);
    //     queue.offer(root.val);
    //     dfs(root.right);
    // }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */