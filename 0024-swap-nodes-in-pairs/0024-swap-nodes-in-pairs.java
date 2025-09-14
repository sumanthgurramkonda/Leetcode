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
    public ListNode swapPairs(ListNode head) {
        int size = 0;
        ListNode temp = head;
        while(temp!=null){
            size++;
            temp = temp.next;
        }
        if(size<2)return head;

        ListNode[] nodeList = new ListNode[size];
        for(int i=0;i<size;i++){
            nodeList[i]=head;
            head = head.next;
        }
        for(int i=0;i<size;i++){
            nodeList[i].next = null;
        }
        for(int i=0;i<size-1;i+=2){
            ListNode temp1 = nodeList[i];
            nodeList[i] = nodeList[i+1];
            nodeList[i+1]=temp1;
        }
        for(int i=0;i<size-1;i++){
            nodeList[i].next = nodeList[i+1];
        }
        return nodeList[0];
        // ListNode head1 = null;
        // ListNode prevNode = null;
        // while(size>1){
        //     ListNode[] nodes = reversePair(head,prevNode);
        //     if(head1==null){
        //         head1=nodes[0];
        //     }
        //     nodes[1].next = nodes[2];
        //     head = nodes[2];
        //     prevNode = nodes[1];
        //     size-=2;
        // }
        // return head1;
    }

    public ListNode[] reversePair(ListNode currentNode, ListNode prevNode){

        ListNode nextNode = null;
        ListNode firstNode = currentNode;
        for(int i=0;i<2;i++){
            nextNode = currentNode.next;
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = nextNode;
        }
        return new ListNode[]{prevNode,firstNode,currentNode};
    }

}