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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode val = new ListNode(-1);
        val.next = head;
        ListNode temp = val;
        ListNode start = null;
        ListNode end = null;
        ListNode prev = val;
        int count = 0;
        temp = temp.next;

        while(temp != null) {
            count++;
            if(count == left) {
                start = temp;
            }
            if(start == null) {
                prev = temp;
            }
            if(count == right) {
                end = temp;
                break;
            }
            temp = temp.next;
        }

        if(start == null || end==null) {
            return head;
        }
        ListNode oldStart = start;
        ListNode oldEnd = end.next;
        end.next = null;
        prev.next = null;
        ListNode revHead = rev(start);
        prev.next = revHead;
        oldStart.next = oldEnd;

        return val.next;
    }

    ListNode rev(ListNode start) {
        if(start == null || start.next == null) {
            return start;
        }
        ListNode next = rev(start.next);
        start.next.next = start;
        start.next = null;
        return next; 
    }
}