/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {

    public ListNode detectCycle(ListNode head) {
        
        ListNode fastPointer = head;
        ListNode slowPointer = head;
        while(fastPointer!=null && fastPointer.next!=null){
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
            if(slowPointer==fastPointer)break;
        }
        if(fastPointer==null || fastPointer.next==null)return null;
        while(head!=slowPointer){
            head = head.next;
            slowPointer = slowPointer.next;
        }
        return head;
    }
}