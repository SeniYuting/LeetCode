package solution.c_title21_30;

import helper.ListNode;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * <p>
 * 定义:ptr1指向要交换的pair的前一个node，ptr2指向要交换的pair的第一个node 当链表长度为奇数时，ptr2.next可能为空
 * 当链表长度为偶数时，ptr2可能为空
 * 好题~
 */
public class SwapNodesInPairs {

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;

        ListNode ptr1 = fakeHead;
        ListNode ptr2 = head;

        while (ptr2 != null && ptr2.next != null) {
            ListNode node = ptr1.next;
            ptr1.next = ptr2.next;
            ptr2.next = ptr1.next.next;
            ptr1.next.next = node;
            ptr1 = ptr2;
            ptr2 = ptr2.next;
        }

        // 注意，此时head已经为null
        return fakeHead.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);

        ListNode result = swapPairs(l1);

        while (result != null) {
            System.out.print(result.val + " -> ");
            result = result.next;
        }
    }

}
