package leetcode;

public class AddLinkedLists {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = null;
        ListNode prev = null;

        int carryOver = 0;

        while ( (l1 != null) || (l2 != null) ) {

            System.out.println("While loop iteration");

            if (l1 == null && l2 == null) {
                break;
            }
            ListNode current = new ListNode();
            if ( (l1 != null && l1.next == null && l2 == null) || (l2 != null && l2.next == null && l1 == null)
                    || (l1!=null && l1.next == null && l2!=null && l2.next == null)) {
                
                System.out.println("If");
                int currsum = 0;
                if (l1 != null) {
                    currsum += l1.val;
                }
                if (l2 != null) {
                    currsum += l2.val;
                }
                currsum += carryOver;

                if(currsum >= 10){
                    ListNode terminatingNode = new ListNode();
                    terminatingNode.val = currsum/10;
                    terminatingNode.next = null;
                    current.val = currsum%10;
                    current.next = terminatingNode;

                }else{
                    current.val = currsum;
                    current.next = null;
                }

                

            } else {
                System.out.println("else");
                int currsum = 0;
                if (l1 != null) {
                    currsum += l1.val;
                }
                if (l2 != null) {
                    currsum += l2.val;
                }
                currsum += carryOver;
                current.val = currsum % 10;
                carryOver = currsum / 10;
                current.next = null;
            }

            if (head == null) {
                head = current;
                prev = current;
            } else {
                prev.next = current;
                prev = current;
            }

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }

        }

        return head;

    }
    public static void main(String[] args) {

        ListNode l1_a = new ListNode(0);
        // ListNode l1_b = new ListNode(5);
        // ListNode l1_c = new ListNode(9);
        // ListNode l1_d = new ListNode(4);
        // ListNode l1_e = new ListNode(6);

        // //Provide the links in l1
        // l1_a.next = l1_b;
        // l1_b.next = l1_c;
        // l1_c.next = l1_d;
        // l1_d.next = l1_e;
        // l1_e.next = null;

        ListNode l2_a = new ListNode(2);
        ListNode l2_b = new ListNode(7);
        ListNode l2_c = new ListNode(8);

        //Provide the links in l2
        l2_a.next = l2_b;
        l2_b.next = l2_c;
        l2_c.next = null;

        ListNode l1 = l1_a;
        ListNode l2 = l2_a;

        ListNode ans = addTwoNumbers(l1, l2);

        while(ans != null){
            System.out.print(ans.val + "-->");
            ans = ans.next;
        }
        
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
