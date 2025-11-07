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
    int max = 0;
    public int longestZigZag(TreeNode root) {
        if (root == null) return 0;
        dfs(root.left,false,1);
        dfs(root.right,true,1);
        return max;
    }

    public void dfs(TreeNode root, boolean isRight, int h){
        if(root==null)return;
    
        max = Math.max(max, h);
        if(isRight){
            dfs(root.left,false,h+1);
            dfs(root.right,true,1);
        }else{
            dfs(root.right,true,h+1);
            dfs(root.left,false,1);
        }
        
    }

}