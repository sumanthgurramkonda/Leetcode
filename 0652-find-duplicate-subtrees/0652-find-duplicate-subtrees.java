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
    Map<String, List<TreeNode>> subTrees = new HashMap<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        List<TreeNode> res = new ArrayList<>();
        for(List<TreeNode> nodes : subTrees.values()){
            if(nodes.size()>1)res.add(nodes.get(0));
        }
        return res;
    }

    public String dfs(TreeNode root){
        if(root==null)return "NULL";

        String left = dfs(root.left);
        String right = dfs(root.right);
        String subTree = root.val+","+","+left+","+","+right;
        subTrees.putIfAbsent(subTree,new ArrayList<>());
        subTrees.get(subTree).add(root);
        return subTree;
    }

}