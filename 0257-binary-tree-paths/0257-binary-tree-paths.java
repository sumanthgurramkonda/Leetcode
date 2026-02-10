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

    List<String> res = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root, null);
        return res;
    }

    public void dfs(TreeNode root, String path){
        if(root==null){
            return;
        }
        if(path==null) path = ""+root.val;
        else path = path+"->"+root.val;
        dfs(root.left,path);
        dfs(root.right, path);
        if(root.left==null && root.right==null)
            res.add(path);
    }
}