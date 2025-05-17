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
    public int kthSmallest(TreeNode root, int k) {
        Queue<Integer> queue = new PriorityQueue(Collections.reverseOrder());
        kthSmallest(root,k,queue);
        return queue.poll();
    }

    public void kthSmallest(TreeNode root, int k, Queue<Integer> queue){
        if(queue.size()==k)return;
        if(root==null)return;
        kthSmallest(root.left,k,queue);
        if(queue.size()<k) queue.add(root.val);
        kthSmallest(root.right,k,queue);
    }
}