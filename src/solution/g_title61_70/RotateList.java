package solution.g_title61_70;

import helper.ListNode;

/**
 * Given a linked list, rotate the list to the right by k places, where k is non-negative.
 * 将链表向后回转k位
 * <p>
 * Example1：
 * Input: 1->2->3->4->5->NULL, k = 2
 * Output: 4->5->1->2->3->NULL
 * <p>
 * Example2：
 * Input: 0->1->2->NULL, k = 4
 * Output: 2->0->1->NULL
 * <p>
 * 思路：将链表变为环，并计算链表长度，再回转length - k%length位
 */
public class RotateList {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);

        ListNode result1 = rotateRight(l1, 2);
        while (result1 != null) {
            System.out.print(result1.val + " -> ");
            result1 = result1.next;
        }

        System.out.println();

        ListNode l2 = new ListNode(0);
        l2.next = new ListNode(1);
        l2.next.next = new ListNode(2);

        ListNode result2 = rotateRight(l2, 4);
        while (result2 != null) {
            System.out.print(result2.val + " -> ");
            result2 = result2.next;
        }
        System.out.println();
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }

        ListNode countHead = head, result = head;  // 仅指针表示，实际是一个ListNode
        int length = 1;
        while (countHead.next != null) {
            length++;
            countHead = countHead.next;
        }
        countHead.next = head;

        k %= length;
        for (int i = 0; i < length - k - 1; i++) {
            result = result.next;
        }

        head = result.next;
        result.next = null;

        return head;
    }

}
