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
    public boolean isValidBST(TreeNode root) {
        if(root.left==null && root.right==null)return true;
        return isValidBst(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBst(TreeNode root,long left, long right){
       if(root==null)return true;
       if(!(root.val<right && root.val>left))return false;
       return isValidBst(root.left,left,root.val) && isValidBst(root.right,root.val,right);
    }
}

