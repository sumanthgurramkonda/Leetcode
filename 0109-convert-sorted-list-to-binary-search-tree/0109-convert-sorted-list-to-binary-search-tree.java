/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        int size = 0;
        ListNode temp = head;
        while(temp!=null){
            temp=temp.next;
            size++;
        }
        ListNode[] nodes = new ListNode[size];
        temp = head;
        for(int i=0;i<size;i++){
            nodes[i] = temp;
            temp = temp.next;
        }
        return bst(nodes,0,size-1);
    }

    public TreeNode bst(ListNode[] nodes, int start,int end){
        if(start>end)return null;
        if(start==end)return new TreeNode(nodes[start].val);
        int mid = (start+end)/2;
        TreeNode node = new TreeNode(nodes[mid].val);
        node.left = bst(nodes,start,mid-1);
        node.right = bst(nodes,mid+1,end);
        return node;
    }
}
