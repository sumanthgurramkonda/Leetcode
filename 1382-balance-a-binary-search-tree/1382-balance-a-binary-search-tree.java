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
    List<Integer> list = new ArrayList();
    public TreeNode balanceBST(TreeNode root) {
        inOrder(root);
        return constructTree(0,list.size()-1);
    }

    public TreeNode constructTree(int start, int end){
        if(start>end) return null;
        
        int mid = (start+end)/2;
        TreeNode node = new TreeNode(list.get(mid));
        node.left = constructTree(start,mid-1);
        node.right = constructTree(mid+1,end);
        return node;
    }

    public void inOrder(TreeNode root){
        if(root==null)return;
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }
}