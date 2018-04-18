package solution.c_title21_30;

import helper.ListNode;

/**
 * 
 * Merge two sorted linked lists and return it as a new list. The new list
 * should be made by splicing together the nodes of the first two lists.
 * 
 * 递归
 *
 */
public class MergeTwoSortedLists {

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		} else if (l2 == null) {
			return l1;
		} else if ((int) l1.val < (int) l2.val) {
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		} else {
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}

	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(4);

		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(3);
		l2.next.next = new ListNode(4);

		ListNode result = mergeTwoLists(l1, l2);
		while (result != null) {
			System.out.print(result.val + " -> ");
			result = result.next;
		}
	}

}
