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
class Solution {
    Queue<Integer> queue = new LinkedList<>();
    boolean isValid = true;
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        dfs(root1);
        dfs1(root2);
        return isValid && queue.isEmpty();
    }

    public void dfs(TreeNode root){
        if(root==null)return;
        if(root.left==null && root.right==null) queue.offer(root.val);
        dfs(root.left);
        dfs(root.right);
    }

    public void dfs1(TreeNode root){
        if(!isValid) return;
        if(root==null)return;
        if(root.left==null && root.right==null) {
            if(queue.isEmpty()){
                isValid = false;
            }else{
                int val = queue.poll();
                if(root.val != val){
                    isValid = false;
                }
            }
            return;
        }
        dfs1(root.left);
        dfs1(root.right);
        
    }
}