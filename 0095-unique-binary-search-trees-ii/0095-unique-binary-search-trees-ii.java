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
    
    public List<TreeNode> generateTrees(int n) {
        return dfs(1,n);
    }

    public List<TreeNode> dfs(int left, int right){

       if(left==right){
        List<TreeNode> list = new ArrayList();
        list.add(new TreeNode(left));
        return list;
       }
       if(left>right) return null;

       List<TreeNode> res = new ArrayList<>();

       for(int i=left;i<=right;i++){
            List<TreeNode> leftNode = dfs(left,i-1);
            List<TreeNode> rightNode = dfs(i+1,right);
            if(leftNode==null){
                for(TreeNode r : rightNode){
                    TreeNode node = new TreeNode(i,null,r);
                    res.add(node);
                }
            }else if(rightNode==null){
                for(TreeNode l : leftNode){
                    TreeNode node = new TreeNode(i,l,null);
                    res.add(node);
                }
            }else{
                for(TreeNode l : leftNode){
                    for(TreeNode r : rightNode){
                        TreeNode node = new TreeNode(i,l,r);
                        res.add(node);
                    }
                }
            }
            
       }
       return res;
    }

}