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
    public void reorderList(ListNode head) {
        
        if(head == null || head.next==null) {
            return;
        }

        ListNode slow = head;
        ListNode fast = head.next.next;

        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode next = slow.next;

        slow.next = null;

        ListNode top = reverse(next);

        ListNode l1 = head;
        ListNode l2 = top;
        while (l1!=null && l2!=null) {
            ListNode l3 = l1.next;
            l1.next = l2;
            l1 = l2;
            l2 = l3;
        }

    }

    ListNode reverse(ListNode next) {
        if(next == null || next.next==null) {
            return next;
        }

        ListNode top = reverse(next.next);
        next.next.next = next;
        next.next = null;
        return top;
    }
}