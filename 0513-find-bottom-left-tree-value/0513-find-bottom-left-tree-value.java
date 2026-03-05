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
    int maxHeight = -1;
    int res = -1;
    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    public void dfs(TreeNode root, int h){
        if(root==null)return;
        if(root.left==null && root.right==null){
            if(h>maxHeight){
                maxHeight = h;
                res = root.val;
                return ;
            }
        }
        dfs(root.left, h+1);
        dfs(root.right, h+1);
    }
}