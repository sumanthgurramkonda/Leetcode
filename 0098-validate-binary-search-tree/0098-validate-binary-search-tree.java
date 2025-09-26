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
        if(root==null)return true;
         int leftMin = getMin(root.left);
         int rightMin = getMin(root.right);
         if(leftMin>rightMin) return false;
         return isValidBst(root);
    }

    public boolean isValidBst(TreeNode root){
        if(root==null)return true;
        TreeNode left = root.left, right = root.right;
        if(left!=null && root.val<=left.val)return false;
        if(right!=null && root.val>=right.val)return false;
        return isValidBST(left) && isValidBST(right);
    }

    public int getMin(TreeNode root){
        if(root==null)return Integer.MAX_VALUE;
        int left = getMin(root.left);
        int right = getMin(root.right);
        return Math.min(Math.min(root.val,left),right);
    }
}

