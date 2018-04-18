package solution.c_title21_30;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import helper.ListNode;

/**
 * 
 * Merge k sorted linked lists and return it as one sorted list. Analyze and
 * describe its complexity.
 *
 */
public class MergeKSortedLists {

	public static ListNode mergeKLists(ListNode[] lists) {
		ListNode head = new ListNode(0);
		ListNode tmpHead = head;

		List<Integer> valList = new ArrayList<Integer>();

		for (int i = 0; i < lists.length; i++) {
			ListNode list = lists[i];
			while (list != null) {
				valList.add((int) list.val);
				list = list.next;
			}
		}

		Collections.sort(valList); // 排序 O(NlogN)，N为总节点数

		for (int i = 0; i < valList.size(); i++) {
			tmpHead.next = new ListNode(valList.get(i));
			tmpHead = tmpHead.next;
		}

		return head.next;
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(4);

		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(3);
		l2.next.next = new ListNode(4);

		ListNode[] lists = { l1, l2 };

		ListNode result = mergeKLists(lists);
		while (result != null) {
			System.out.print(result.val + " -> ");
			result = result.next;
		}
	}

}
