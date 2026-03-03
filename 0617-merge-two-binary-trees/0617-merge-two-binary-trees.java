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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1==null && root2==null)return null;

        TreeNode left = mergeTrees(root1!=null ? root1.left : null, root2!=null ? root2.left : null);
        TreeNode right = mergeTrees(root1!=null ? root1.right : null, root2!=null ? root2.right : null);
        int val = (root1!=null ? root1.val : 0) + (root2!=null ? root2.val : 0);
        return new TreeNode(val, left,right);
        
    }
}