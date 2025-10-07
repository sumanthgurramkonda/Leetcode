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

    public ListNode mergeKLists(ListNode[] lists) {

        int n = lists.length;
        if(n==0)return null;
        for(int i=0;i<n-1;i++){
            lists[i+1]=mergeLists(lists[i], lists[i+1]);
        }
        return lists[n-1];
    }

    public ListNode mergeLists(ListNode list1, ListNode list2){
        ListNode node = new ListNode();
        ListNode temp = node;
        while(list1!=null && list2!=null){
            if(list1.val<list2.val){
                node.next = list1;
                list1 = list1.next;
            }else{
                node.next = list2;
                list2 = list2.next;
            }
            node=node.next;
        }
        while(list1!=null){
            node.next = list1;
            list1 = list1.next;
            node = node.next;
        }
        while(list2!=null){
            node.next = list2;
            list2 = list2.next;
            node = node.next;
        }
        return temp.next;
    }
}