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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();
        if(root==null)return res;
        boolean leftToRight = true;
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new LinkedList();
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                if(leftToRight){
                    list.add(node.val);
                }else{
                    list.addFirst(node.val);
                }
                if(node.left!=null)queue.offer(node.left);
                if(node.right!=null)queue.offer(node.right);
            }
            res.add(list);
            leftToRight = !leftToRight;
        }
        return res;
    }
}




