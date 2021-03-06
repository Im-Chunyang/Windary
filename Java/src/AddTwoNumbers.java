import java.util.ArrayList;
import java.util.List;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * <p>
 * Result: Accepted
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode tmp1 = l1.next;
        ListNode tmp2 = l2.next;

        List<ListNode> results = new ArrayList<>();

        boolean addOne = l1.val + l2.val >= 10;

        ListNode result = new ListNode((l1.val + l2.val) % 10);

        if (addOne) {
            result.next = new ListNode(1);
        }

        results.add(result);

        while (true) {
            if (tmp1 == null && tmp2 == null) {
                break;
            } else {
                int tmp = 0;
                if (tmp1 == null) {
                    tmp = tmp2.val;
                } else if (tmp2 == null) {
                    tmp = tmp1.val;
                } else {
                    tmp = tmp1.val + tmp2.val;
                }

                if (addOne) {
                    tmp += 1;
                }

                addOne = tmp >= 10;
                result = new ListNode(tmp % 10);

                if (addOne) {
                    result.next = new ListNode(1);
                }

                results.add(result);

                if (tmp1 != null) {
                    tmp1 = tmp1.next;
                }
                if (tmp2 != null) {
                    tmp2 = tmp2.next;
                }
            }

        }

        ListNode rst = results.get(0);
        for (int i = 1; i < results.size(); i++) {
            rst.next = results.get(i);
            rst = rst.next;
        }

        return results.get(0);
    }

    public static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof ListNode) {
                ListNode node = (ListNode) obj;
                return this.next == null && node.next == null || this.val == node.val && (this.next != null) && this.next.equals(node.next);
            }
            return false;
        }

    }

}
