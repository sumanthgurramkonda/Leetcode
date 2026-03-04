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
    public List<List<Integer>> levelOrder(TreeNode root) {
        dfs(root,1);
        return result;
    }
    List<List<Integer>> result = new ArrayList();

    public void dfs(TreeNode root, int height){
        if(root==null)return;
        if(result.size()<height){
            List<Integer> list = new ArrayList();
            result.add(list);
        }
        List<Integer> list = result.get(height-1);
        list.add(root.val);
        dfs(root.left,height+1);
        dfs(root.right,height+1);
        
    }
    
}

/*
3
9, 20
15, 7
*/