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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode curr = head;
        int length = 0;

        while (curr != null) {
            curr = curr.next;
            length++;
        }

        k = k % length;

        if (k == 0) return head;

        ListNode fast = head;
        ListNode slow = head;

        while (k > 0) {
            fast = fast.next;
            k--;
        }

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        ListNode ans = slow.next;
        fast.next = head;
        slow.next = null;

        return ans;
    }
}