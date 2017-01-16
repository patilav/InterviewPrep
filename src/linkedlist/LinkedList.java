package linkedlist;

public class LinkedList {

	ListNode head;

	public ListNode insert(int data) {

		ListNode node = new ListNode(data);
		if (head == null) {
			head = node;
		} else {
			ListNode current = head;

			while (current.next != null) {
				current = current.next;
			}
			current.next = node;
		}
		return head;
	}

	public ListNode appendToTail(ListNode data) {

		if (head == null) {
			head = data;
		} else {
			ListNode current = head;

			while (current.next != null) {
				current = current.next;
			}
			current.next = data;
		}
		return head;
	}

	public void delete(int data) {
		if (head == null) {
			return;
		} else if (head.data == data) {
			head = head.next;
		} else {
			ListNode prev = null;
			ListNode current = head;

			boolean isFound = false;
			while (current != null) {
				prev = current;
				current = current.next;
				if (current.data == data) {
					isFound = true;
					break;
				}
			}

			if (isFound) {
				prev.next = prev.next.next;
				// prev.next = current.next;
			}
		}
	}

	public void printList() {

		if (head == null) {
			return;
		}
		ListNode current = head;
		while (current != null) {
			System.out.print(current + " ");
			current = current.next;
		}
		System.out.println();
	}

}
