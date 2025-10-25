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
    int count=0;

    private final String COVERED = "COVERED";
    private final String NOT_COVERED = "NOT_COVERED";
    private final String HAS_CAMERA = "HAS_CAMERA";
    private final String NO_CAMERA = "NO_CAMERA";

    public int minCameraCover(TreeNode root) {
        if(root==null)return 0;
        if(root.left==null && root.right==null)return 1;
        if(dfs(root)==0)count++;
        return count;
    }

    public int dfs(TreeNode root){
        if(root==null)return 1; 
        int left = dfs(root.left);
        int right = dfs(root.right);
        if(left==1 && right==1){
            return 0;
        }else if(left==0 || right==0){
            count++;
            return 2;
        }if(left!=0 && right!=0){
            return 1;
        }else {
            return 0;
        }
    }

}