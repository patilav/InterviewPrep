package linkedlist;

public class TwoSumReverseList {
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode current1 = l1;
		ListNode current2 = l2;

		ListNode res = null;
		ListNode prev = null;

		int carry = 0;
		while (current1 != null || current2 != null) {
			int sum = carry + (current1 == null ? 0 : current1.data) + (current2 == null ? 0 : current2.data);

			carry = (sum >= 10) ? 1 : 0;

			sum = sum % 10;

			ListNode temp = new ListNode(sum);

			if (res == null) {
				res = temp;
				prev = temp;
			} else {
				prev.next = temp;
				prev = prev.next;
			}

			if (current1 != null) {
				current1 = current1.next;
			}

			if (current2 != null) {
				current2 = current2.next;
			}
		}

		if (carry > 0) {
			ListNode temp = new ListNode(carry);
			prev.next = temp;
		}

		return res;
	}
	
	public static void printList(ListNode current) {

		while (current != null) {
			System.out.print(current + " ");
			current = current.next;
		}
		System.out.println();
	}
	
	public static void main(String args[]){
		LinkedList list1 = new LinkedList();
		list1.insert(2);
		list1.insert(4);
		list1.insert(3);
		
		LinkedList list2 = new LinkedList();
		list2.insert(5);
		list2.insert(6);
		list2.insert(4);
		list2.insert(1);
		
		ListNode res = addTwoNumbers(list1.head, list2.head);
		printList(res);
	}
}
