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
    int res;
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        // Queue<Integer> queue = new PriorityQueue(Collections.reverseOrder());
        // kthSmallest(root,k,queue);
        // return queue.poll();
        kthSmallest1(root,k);
        return res;
    }

    public void kthSmallest(TreeNode root, int k, Queue<Integer> queue){
        if(queue.size()==k)return;
        if(root==null)return;
        kthSmallest(root.left,k,queue);
        if(queue.size()<k) queue.add(root.val);
        kthSmallest(root.right,k,queue);
    }

    public void kthSmallest1(TreeNode root, int k){
        if(root==null)return;
        if(count==k)return;
        kthSmallest1(root.left,k);
        count++;
        if(count==k)res = root.val;
        kthSmallest1(root.right,k);
    }
}