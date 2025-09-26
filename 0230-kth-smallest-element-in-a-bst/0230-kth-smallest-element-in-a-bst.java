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
    
    public int kthSmallest(TreeNode root, int k) {
        kthSmallestElement(root,k);
        return res;
    }
    int count;
    int res;
    public void kthSmallestElement(TreeNode root,int k){
        if(root==null)return;
        kthSmallestElement(root.left,k);
        count += 1;
        if(count==k)res = root.val;
        kthSmallestElement(root.right,k);

    }
}
