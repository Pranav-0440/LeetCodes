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
        // Step 1: Create a dummy node that points to the head
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Step 2: Create two pointers, both starting at dummy
        ListNode fast = dummy;
        ListNode slow = dummy;

        // Step 3: Move fast pointer n+1 steps ahead
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // Step 4: Move both pointers until fast reaches the end
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Step 5: Skip the target node
        slow.next = slow.next.next;

        // Step 6: Return the updated list
        return dummy.next;
    }
}