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
    public ListNode rev(ListNode l){
        ListNode curr = l;
        ListNode prev = null;
        ListNode next;

        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1.val==0){
            return l2;
        }else if(l2.val==0){
            return l1;
        }

        ListNode t1 = rev(l1);
        ListNode t2 = rev(l2);

        ListNode c1 = t1;
        ListNode c2 = t2;
        int carry = 0;
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while(c1!=null&&c2!=null){
                int k = c1.val + c2.val + carry;
            
                if(k>9){
                    carry = 1;
                    k = k%10;
                }else{
                    carry = 0;
                }
                ListNode a1 = new ListNode(k);
                temp.next = a1;
                temp = temp.next;
                

                c1 = c1.next;
                c2 = c2.next;
            
        }
        while(c1!=null){
            int k = c1.val + carry;
            if (k > 9) {
                carry = 1;
                k = k % 10;
            } else {
                carry = 0;
            }
            ListNode a1 = new ListNode(k);
            temp.next = a1;
            temp = temp.next;

            c1 = c1.next;
        }

        while(c2!=null){
            int k = c2.val + carry;
            if (k > 9) {
                carry = 1;
                k = k % 10;
            } else {
                carry = 0;
            }
            ListNode a1 = new ListNode(k);
            temp.next = a1;
            temp = temp.next;

            c2 = c2.next;
        }
        if (carry > 0) {
            temp.next = new ListNode(carry);
        }
        ListNode finalans = rev(dummy.next);
        return finalans;
    }
}