/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> nodeSet = new HashSet();

        while(headA!=null || headB!=null){
            if(headA!=null){
                if(nodeSet.contains(headA))return headA;
                nodeSet.add(headA);
                headA = headA.next;
            }
            if(headB!=null){
                if(nodeSet.contains(headB))return headB;
                nodeSet.add(headB);
                headB = headB.next;
            }
        }
        return null;
    }
}