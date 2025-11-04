/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root,p,q);
        return res;
    }

    TreeNode res = null;
    public TreeNode dfs(TreeNode root, TreeNode p, TreeNode q){
        if(root==null)return null;

        TreeNode left = dfs(root.left, p, q);
        TreeNode right = dfs(root.right, p, q);

        if(root==p || root==q){
            res = root;
            return root;
        }
        if(left==p && right==q || left==q && right==p){
            res = root;
            return root;
        }
        // if((root==p && right==q || left==q) || (root==q && right==p || left==p))return root;
        if(left==p || left==q){
            res = left;
            return left;
        }
        if(right==p || right==q){
            res = right;
            return right;
        }
        return root;
    }
}