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
    boolean isHeightBalanced = true;
    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return isHeightBalanced;
    }

    public int dfs(TreeNode root){
        if(root==null)return 0;
        if(!isHeightBalanced) return 0;
        int left = dfs(root.left)+1;
        int right = dfs(root.right)+1;
        if(left > right){
            if(left>right+1) isHeightBalanced = false;
        }
        else if(right > left){
            if(right>left+1) isHeightBalanced = false;
        }
        return Math.max(left,right);
    }
}