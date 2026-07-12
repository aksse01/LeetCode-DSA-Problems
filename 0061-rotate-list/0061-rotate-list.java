class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        int len = 0;
        
        // 1. Handle edge cases
        if (head == null || head.next == null) return head;
        
        // 2. Find the length and the original tail
        ListNode count = head;
        while (count.next != null) {
            len++;
            count = count.next;
        }
        len++; // Account for the final node
        
        // 3. Optimize k
        k = k % len;
        
        // 4. Locate the new tail
        ListNode p = head;
        for (int i = 0; i < (len - k - 1); ++i) {
            p = p.next;
        }
        
        // 5 & 6. Form the circle, set new head, and break it
        count.next = head;
        head = p.next;
        p.next = null;
        
        // 7. Return the new rotated list
        return head;
    }
}