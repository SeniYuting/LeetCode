package solution.c_title21_30;

import helper.ListNode;

import java.util.Stack;

/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * k is a positive integer and is less than or equal to the length of the linked list.
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * Only constant memory is allowed.
 * <p>
 * 好题~
 * 思路1：每k个node进栈，再按照出栈的顺序连接，则自然反转，缺点：Stack速度较慢
 * 思路2：链表反转
 */
public class ReverseNodesInKGroup {

    public static ListNode reverseKGroup1(ListNode head, int k) {

        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode headTmp = head;

        for (int i = 0; i < k; i++) {
            if (head != null) {
                stack.push(head);
            } else {
                return headTmp;
            }
            head = head.next;
        }

        ListNode first = stack.pop();
        ListNode result = first;

        for (int i = 0; i < k - 1; i++) {
            first.next = stack.pop();
            first = first.next;
        }

        first.next = reverseKGroup1(head, k);

        return result;
    }

    public static ListNode reverseKGroup2(ListNode head, int k) {

        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;

        ListNode ptr1 = fakeHead;
        ListNode ptr2 = head;

        int i = 0;
        while (head != null) {
            i++;
            head = head.next;
        }

        while (i >= k) {
            for (int j = 0; j < k - 1; j++) {
                ListNode node = ptr1.next;
                ptr1.next = ptr2.next;
                ptr2.next = ptr1.next.next;
                ptr1.next.next = node;
            }
            ptr1 = ptr2;
            ptr2 = ptr2.next;
            i -= k;
        }

        return fakeHead.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);

//        ListNode result1 = reverseKGroup1(l1, 2);
        ListNode result1 = reverseKGroup2(l1, 2);
        while (result1 != null) {
            System.out.print(result1.val + " -> ");
            result1 = result1.next;
        }

        System.out.println();

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(2);
        l2.next.next = new ListNode(3);
        l2.next.next.next = new ListNode(4);
        l2.next.next.next.next = new ListNode(5);

//        ListNode result2 = reverseKGroup1(l2, 3);
        ListNode result2 = reverseKGroup2(l2, 3);
        while (result2 != null) {
            System.out.print(result2.val + " -> ");
            result2 = result2.next;
        }
    }

}
