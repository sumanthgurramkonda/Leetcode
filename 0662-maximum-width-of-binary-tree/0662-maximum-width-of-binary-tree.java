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
    public class Pair{
        TreeNode node;
        int val;
        public Pair(TreeNode node, int val){
            this.node = node;
            this.val = val;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root,1));
        int res = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            int min = 0;
            int max = 0;
            for(int i=0;i<size;i++){
                Pair pair = queue.poll();
                if(i==0)min = pair.val;
                if(i==size-1)max = pair.val;
                max = Math.max(max, pair.val);
                TreeNode node = pair.node;
                if(node.left!=null){
                    queue.add(new Pair(node.left,pair.val*2));
                }
                if(node.right!=null){
                    queue.add(new Pair(node.right,pair.val*2+1));
                }
            }
            res = Math.max(res,max-min+1);
        }
        return res;
    }
}