package solution.a_title1_10;

import helper.ListNode;

/**
 * 
 * You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order and each of their nodes
 * contain a single digit. Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself. 好题~
 * 
 * Example: Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8
 *
 */

public class AddTwoNumbers {

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(0);
		ListNode p = l1, q = l2, curr = head;
		int carry = 0;
		while (p != null || q != null) {
			int x = (p != null) ? (int) p.val : 0;
			int y = (q != null) ? (int) q.val : 0;
			int sum = carry + x + y;
			carry = sum / 10;
			curr.next = new ListNode(sum % 10);
			curr = curr.next;
			if (p != null)
				p = p.next;
			if (q != null)
				q = q.next;
		}
		if (carry > 0) {
			curr.next = new ListNode(carry);
		}
		return head.next;
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(3);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(2);

		ListNode l2 = new ListNode(4);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(5);

		ListNode result = addTwoNumbers(l1, l2);
		System.out.println(result.val + " -> " + result.next.val + " -> " + result.next.next.val);
	}

}
