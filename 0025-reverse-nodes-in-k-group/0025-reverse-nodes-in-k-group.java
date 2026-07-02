/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        
        // Step 1: Verify if there are at least k nodes left to reverse 📐
        ListNode tail = head;
        for (int i = 0; i < k; i++) {
            if (tail == null) {
                return head; // Fewer than k nodes left, leave them untouched!
            }
            tail = tail.next;
        }

        // Step 2: Reverse the local k-group segment 🔀
        ListNode newHead = reverse(head, tail);
        
        // Step 3: Recursively solve for the remaining chunks and connect links 🧵
        head.next = reverseKGroup(tail, k);
        
        return newHead;
    }

    // Helper method to reverse nodes from 'curr' up to (but excluding) 'end'
    public ListNode reverse(ListNode curr, ListNode end) {
        ListNode prev = null;
        while (curr != end) {
            ListNode next = curr.next; // Save the next node reference
            curr.next = prev;          // Reverse the current pointer
            prev = curr;               // Advance prev
            curr = next;               // Advance curr
        }
        return prev; // 'prev' becomes the new head of this reversed block
    }
}