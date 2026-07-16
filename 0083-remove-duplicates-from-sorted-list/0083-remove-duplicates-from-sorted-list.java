/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {

        // Empty list or a single node has no duplicates
        if (head == null || head.next == null) {
            return head;
        }

        ListNode curr = head;

        // Traverse the sorted list
        while (curr != null && curr.next != null) {

            // Remove duplicate node
            if (curr.val == curr.next.val) {
                curr.next = curr.next.next;
            }

            // Move to the next distinct value
            else {
                curr = curr.next;
            }
        }

        return head;
    }
}