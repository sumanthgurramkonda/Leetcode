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
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return root;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        // invertTree1(root.left,root.right);
        return root;
    }

    public void invertTree1(TreeNode left,TreeNode right){
        if(left==null && right==null) return;
        if(left==null && right!=null){
            left = new TreeNode();
            left.val = right.val;
            right = null;
            invertTree1(left.left,null);
        }
        else if(right==null && left!=null){
           right = new TreeNode();
           right.val = left.val;
           left = null;
           invertTree1(null,right.left);
        }
        else{
            int temp = left.val;
            left.val = right.val;
            right.val = temp;
        }
        invertTree1(left!=null ? left.left : null, right!=null ? right.right : null);
        invertTree1(left!=null ? left.right : null, right!=null ? right.left : null);
    }
}


