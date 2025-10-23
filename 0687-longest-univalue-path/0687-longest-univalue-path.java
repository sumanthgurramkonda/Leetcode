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

    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return res>0 ? res-1 : 0;
    }
    int res=0;
    public int[] dfs(TreeNode root){
        if(root==null)return null;

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        if(left==null && right==null){
            return new int[]{root.val, 1};
        }else if(left==null && right!=null){
            
            if(root.val==right[0]){
                right[1]++;
            }else{
                right[1]=1;
                right[0]=root.val;
            }
            res = Math.max(res, right[1]);
            return right;
        }else if(left!=null && right==null){
            if(root.val==left[0]){
                left[1]++;
            }else{
                left[1]=1;
                left[0]=root.val;
            }
            res = Math.max(res, left[1]);
            return left;
        }else{
            res = Math.max(res,Math.max(left[1],right[1]));
            if(root.val==left[0] && root.val==right[0]){
                res = Math.max(res,left[1]+right[1]+1);
                left[1] = Math.max(left[1],right[1])+1;
                return left;
            }else if(root.val==left[0]){
                left[1]++;
                res = Math.max(res,left[1]);
                return left;
            }else if(root.val==right[0]){
                right[1]++;
                res = Math.max(res,right[1]);
                return right;
            }
        }
        return new int[]{root.val,1};
    }
}