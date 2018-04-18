package helper;

public class ListNode {
	public Object val;
	public ListNode next;

	public ListNode(Object val) {
		this(val, null);
	}

	public ListNode(Object val, ListNode next) {
		this.val = val;
		this.next = next;
	}

}
