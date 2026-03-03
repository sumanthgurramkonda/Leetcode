/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode curr = root;
        while(curr!=null){
            if((curr == p || curr == q) || (curr.val > p.val && curr.val < q.val) || (curr.val < p.val && curr.val > q.val)) return curr;
            if(p.val>curr.val && q.val>curr.val){
                curr=curr.right;
            }
            else if(p.val<curr.val && q.val<curr.val){
                curr=curr.left;
            }
        }
        return null;
    }
}