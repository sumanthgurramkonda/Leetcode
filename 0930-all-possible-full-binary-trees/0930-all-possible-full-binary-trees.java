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
    public List<TreeNode> allPossibleFBT(int n) {
        Map<Integer, List<TreeNode>> memo = new HashMap();
        List<TreeNode> result = new ArrayList();
        if(memo.containsKey(n))return memo.get(n);
        if(n==1){
            result.add(new TreeNode(0));
            return result;
        }
        for(int l=1;l<n;l+=2){
           int r = n-1-l;
           List<TreeNode> leftResult = allPossibleFBT(l);
           List<TreeNode> rightResult = allPossibleFBT(r);

           for (TreeNode left : leftResult){
                for(TreeNode right : rightResult){
                    TreeNode node = new TreeNode(0,left,right);
                    result.add(node);
                }
           }
        }
        memo.put(n,result);
        return result;
    }
}