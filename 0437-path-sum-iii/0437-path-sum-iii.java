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
    List<Integer> list = new LinkedList();
    int res = 0;
    public int pathSum(TreeNode root, int targetSum) {
        dfs(root,0,targetSum);
        return res;   
    }

    public void dfs(TreeNode root,long sum,int target){
        if(root==null)return;
        sum+=root.val;
        // if(root.val==target)res+=1;
        if(sum==target)res+=1;
       
        long sum1 = sum;
        for(int val : list){
            sum1 -= val;
            if(sum1==target)res++;
        }
        
        list.add(root.val);
        dfs(root.left,sum,target);
        dfs(root.right,sum,target);
        list.removeLast();
    }
}






