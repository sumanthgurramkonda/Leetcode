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
    List<TreeNode> list = new ArrayList<>();
    public void flatten(TreeNode root) {
        dfs(root);
        root = null;
        for(TreeNode node : list){
            if(root==null){
                root=node;
                node.left = null;
                continue;
            }
            root.right = node;
            node.left = null;
            root=node;
        }
    }

    public void dfs(TreeNode root){
        if(root==null)return;
        list.add(root);
        dfs(root.left);
        dfs(root.right);
    }
}