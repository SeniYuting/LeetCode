package solution.b_title11_20;

import helper.ListNode;

/**
 * Given a linked list, remove the nth node from the end of list and return its
 * head.
 * 
 * 思路： 使用两个指针first和second，first指针先移动n步，则两指针相差n步，同时移动，first指针到末尾，second指针到正确的位置
 * 
 * 好题~
 *
 */
public class RemoveNthNodeFromEndOfList {

	public static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode node = new ListNode(0, head);

		ListNode first = node, second = node;
		for (int i = 0; i <= n; i++) {
			first = first.next;
		}

		while (first != null) {
			first = first.next;
			second = second.next;
		}

		second.next = second.next.next;

		return node.next;
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(3);
		l1.next.next.next = new ListNode(4);
		l1.next.next.next.next = new ListNode(5);

		ListNode result = removeNthFromEnd(l1, 2);
		while (result != null) {
			System.out.print(result.val + " -> ");
			result = result.next;
		}
	}

}
