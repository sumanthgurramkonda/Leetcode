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

    public TreeNode sortedArrayToBST(int[] nums) {
        
        return dfs(nums,0,nums.length-1);
    }

    public TreeNode dfs(int[] nums, int l, int r){
        if(l>r)return null;
        // if(l==r) return new TreeNode(nums[l]);
        int mid = (l+r)/2;
        TreeNode left = dfs(nums, l, mid-1);
        TreeNode right = dfs(nums, mid+1, r);
        return new TreeNode(nums[mid], left, right);
    }
}