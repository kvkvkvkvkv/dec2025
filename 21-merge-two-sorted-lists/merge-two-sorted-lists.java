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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        ListNode head = new ListNode(-1);
        ListNode next = head;

        while(list1!=null || list2!=null) {

            int val = list1==null?Integer.MAX_VALUE:list1.val;
            int val1 = list2==null?Integer.MAX_VALUE:list2.val;

            if(val<=val1) {
                next.next = list1;
                list1 = list1.next ;
            } else {
                next.next = list2;
                list2 = list2.next;
            }
            next = next.next;
        }
        return head.next;
    }
}