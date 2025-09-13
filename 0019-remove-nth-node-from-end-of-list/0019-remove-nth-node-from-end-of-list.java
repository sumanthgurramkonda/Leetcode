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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(n==0 || head==null)return head;

        if(head.next==null)return null;
        ListNode temp = head;
        int len = 0;
        while(temp!=null){
            len++;
            temp=temp.next;
        }
        temp=head;
        len = len-n;
        if(len==0)return head.next;
        while(len-1>0){
            temp=temp.next;
            len--;
        }
        if(temp!=null){
            ListNode temp1 = temp.next;
            if(temp1!=null){  
                temp.next = temp1.next;
                temp1.next=null;
            }
        }
        return head;
    }

}