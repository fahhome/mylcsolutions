package leetcode;

public class LinkedListAddition {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode curr = null;
        int carry = 0;

        while (l1 != null || l2 != null) {

            ListNode temp = new ListNode();
            temp.next = null;

            int val = 0;
            if (l1 != null && l2 != null) {
                val = l1.val + l2.val + carry;
            } else if (l1 != null && l2 == null) {
                val = l1.val + carry;

            } else {
                val = l2.val + carry;
            }

            if (val >= 10) {
                carry = 1;
                temp.val = val % 10;
            } else {
                carry = 0;
                temp.val = val;
            }

            if (head == null) {
                head = temp;
                curr = head;
            } else {
                curr.next = temp;
                curr = temp;
            }

            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;

        }

        if (carry == 1) {
            ListNode temp = new ListNode();
            temp.val = carry;
            temp.next = null;
            curr.next = temp;
        }

        return head;

    }
    public static void main(String[] args) {
        
    }
}
