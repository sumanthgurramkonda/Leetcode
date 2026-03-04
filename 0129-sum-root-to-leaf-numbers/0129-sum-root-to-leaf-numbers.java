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

    public int sumNumbers(TreeNode root) {
        
        return dfs(root, "");
    }

    public int dfs(TreeNode root, String val){
        if(root==null) return 0;
        if(root.left==null && root.right==null){
            return Integer.parseInt(val+root.val);
        }
        return dfs(root.left, val+root.val)+dfs(root.right, val+root.val);
    }

}