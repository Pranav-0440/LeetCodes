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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Dummy head to simplify result list creation
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        
        int carry = 0;
        
        // Loop through both linked lists
        while (l1 != null || l2 != null || carry != 0) {
            int val1 = (l1 != null) ? l1.val : 0; // Get current l1 value
            int val2 = (l2 != null) ? l2.val : 0; // Get current l2 value
            
            int sum = val1 + val2 + carry;
            carry = sum / 10; // Calculate carry for next digit
            
            current.next = new ListNode(sum % 10); // Set current digit
            current = current.next;
            
            if (l1 != null) l1 = l1.next; // Move l1 pointer
            if (l2 != null) l2 = l2.next; // Move l2 pointer
        }
        
        return dummyHead.next; // First node is dummy, skip it
    }
}