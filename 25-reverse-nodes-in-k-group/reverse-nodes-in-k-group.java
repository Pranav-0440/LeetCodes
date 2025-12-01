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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;

        // Step 1: Check if there are at least k nodes to reverse
        ListNode node = head;
        for (int i = 0; i < k; i++) {
            if (node == null) return head;  // Not enough nodes, return original head
            node = node.next;
        }

        // Step 2: Reverse k nodes
        ListNode prev = null, curr = head, next = null;
        int count = 0;
        while (curr != null && count < k) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }

        // Step 3: Recursively reverse the remaining list
        if (next != null) {
            head.next = reverseKGroup(next, k);
        }

        // Step 4: Return new head after reversal
        return prev;
    }
}