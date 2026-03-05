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
    Map<Integer, Integer> map = new HashMap();
    int index=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;
        for(int i=0;i<n;i++){
            map.put(inorder[i],i);
        }
        return buildTree(preorder,0,n-1);
    }
    public TreeNode buildTree(int[] preorder,int l,int r) {
        if(l>r) return null;
        int rootVal = preorder[index++];
        TreeNode root = new TreeNode(rootVal);
        int mid = map.get(rootVal);

        root.left = buildTree(preorder,l,mid-1);
        root.right = buildTree(preorder,mid+1,r);
        return root;
    }
}