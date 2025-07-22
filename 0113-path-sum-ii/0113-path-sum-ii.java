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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        pathSum(root,targetSum, 0,new ArrayList(),0);
        return pathSumList;
    }
    List<List<Integer>> pathSumList = new ArrayList();
    public void pathSum(TreeNode root, int targetSum, int sum, List<Integer> list,int index){
        
        if(root==null)return;
        if(root.left==null && root.right==null){
            if(sum+root.val==targetSum){
                List<Integer> newList = new ArrayList(list);
                newList.add(root.val);
                pathSumList.add(newList);
            }
            return;
        }
        list.add(index,root.val);
        pathSum(root.left,targetSum,sum+root.val,list,index+1);
        pathSum(root.right,targetSum,sum+root.val,list,index+1);
        list.remove(index);

    }
}