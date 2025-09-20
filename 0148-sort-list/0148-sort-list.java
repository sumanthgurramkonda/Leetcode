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
class Solution {
    public ListNode sortList(ListNode head) {
        return sort(head);
    }

    public ListNode sort(ListNode head){
        if(head==null || head.next==null)return head;
        ListNode temp = head;
        ListNode currentNode = head;
        ListNode prevNode = head;
        while(temp!=null && temp.next!=null){
            prevNode = currentNode;
            currentNode = currentNode.next;
            temp = temp.next.next;
        }
        prevNode.next = null;
        ListNode left = sort(head);
        ListNode right = sort(currentNode);
        return merge(left,right);
    }

    public ListNode merge(ListNode left, ListNode right){
        ListNode temp = new ListNode();
        ListNode head = temp;
        while(left!=null && right!=null){
            if(left.val<right.val){
                temp.next=left;
                left=left.next;
            }else{
                temp.next=right;
                right = right.next;
            }
            temp = temp.next;
        }
        while(left!=null){
            temp.next = left;
            temp = temp.next;
            left = left.next;
        }
        while(right!=null){
            temp.next = right;
            temp = temp.next;
            right = right.next;
        }
        return head.next;
    }
}