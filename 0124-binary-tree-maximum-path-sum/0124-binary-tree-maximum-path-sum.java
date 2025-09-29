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

    public int maxPathSum(TreeNode root) {
        getSum(root);
        return maxSum;
    }
    int maxSum =Integer.MIN_VALUE;
    public int getSum(TreeNode root){
        if(root==null)return 0;

        int left = getSum(root.left);
        int right = getSum(root.right);
        int max = Math.max(left,right);
        // maxSum = Math.max(maxSum, Math.max(root.val, Math.max(left,right)));
        maxSum = Math.max(maxSum, left+right+root.val);
        return max+root.val>0 ? max+root.val : 0;
    }
}