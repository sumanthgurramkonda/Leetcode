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
    public int pairSum(ListNode head) {

        ListNode fastPointer = head;
        ListNode slowPointer = head;
        ListNode prevNode = head;
        while(fastPointer!=null && fastPointer.next!=null){
            fastPointer = fastPointer.next.next;
            prevNode = slowPointer;
            slowPointer = slowPointer.next;
        }

        ListNode newHead = reverseList(prevNode);
        prevNode.next = null;
        int maxPair = 0;
        while(head!=null){
            maxPair = Math.max(maxPair, head.val+newHead.val);
            head = head.next;
            newHead = newHead.next;
        }
        
        return maxPair;
        
    }

    public ListNode reverseList(ListNode head){

        ListNode currentNode = head;
        ListNode prevNode = null;
        while(currentNode!=null){
            ListNode nextNode = currentNode.next;
            currentNode.next=prevNode;
            prevNode = currentNode;
            currentNode = nextNode;
        }
        return prevNode;
    }
}