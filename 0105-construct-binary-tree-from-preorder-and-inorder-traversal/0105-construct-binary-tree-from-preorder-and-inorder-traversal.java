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
    
    Map<Integer, Integer> indexMap = new HashMap<>();
    int index = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;
        for(int i=0;i<n;i++)indexMap.put(inorder[i],i);

        return dfs(preorder, 0,n-1);
        
    }

    public TreeNode dfs(int[] preorder, int l, int r){
        if(l>r)return null;
        int root = preorder[index++];
        int mid = indexMap.get(root);
        TreeNode left = dfs(preorder, l,mid-1);
        TreeNode right = dfs(preorder, mid+1,r);
        return new TreeNode(root,left,right);
    }
}