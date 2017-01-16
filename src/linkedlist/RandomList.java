package linkedlist;

public class RandomList {

	public static class RandomListNode {

		public int data;
		public RandomListNode next;
		public RandomListNode random;

		public RandomListNode() {
		}

		public RandomListNode(int data) {
			this.data = data;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append("Data: " + this.data);
			if (this.next != null) {
				sb.append(" Next: " + this.next.data);
			} else {
				sb.append(" Next: null");
			}

			if (this.random != null) {
				sb.append(" Random: " + this.random.data);
			} else {
				sb.append(" Random: null");
			}
			return sb.toString();
		}
	}

	public static void printList(RandomListNode head) {

		if (head == null) {
			return;
		}
		RandomListNode current = head;
		while (current != null) {
			System.out.println(current + " ");
			current = current.next;
		}
		System.out.println();
	}

	public static RandomListNode copyRandomList(RandomListNode head) {

		if (head == null) {
			return null;
		}

		// 10->20->30--
		RandomListNode current = head;
		while (current != null) {
			// Copy the node
			RandomListNode rand = new RandomListNode(current.data);
			rand.next = current.next;
			rand.random = current.random;

			current.next = rand;
			current = rand.next;
		}

		// 10->10->20->20->30->30--

		// set the head of new node
		RandomListNode head2 = head.next;

		// reset the current pointer
		current = head;
		while (current != null) {
			// point the random
			RandomListNode arbit = current.next;

			if (arbit != null && arbit.random != null) {
				arbit.random = arbit.random.next;
			}

			// detatch arbit
			current.next = arbit.next;
			current = current.next;
			if (current != null) {
				arbit.next = current.next;
			} else {
				arbit.next = null;
			}
		}

		return head2;
	}

	public static void main(String args[]) {
		RandomListNode head = new RandomListNode(10);
		head.next = new RandomListNode(20);
		head.next.next = new RandomListNode(30);
		head.next.next.next = new RandomListNode(40);
		head.next.next.next.next = new RandomListNode(50);

		head.random = head.next.next; // 10->30
		head.next.random = head; // 20->10
		head.next.next.random = head.next.next.next.next; // 30->50
		head.next.next.next.random = head.next.next; // 40->30
		head.next.next.next.next.random = head.next; // 50->20

		printList(head);
		RandomListNode head2 = copyRandomList(head);
		System.out.println("Original list");
		printList(head);
		System.out.println("Random list");
		printList(head2);
		
		RandomListNode h1 = new RandomListNode(-1);
		RandomListNode n1 = new RandomListNode(8);
		RandomListNode n2 = new RandomListNode(7);
		RandomListNode n3 = new RandomListNode(-3);
		RandomListNode n4 = new RandomListNode(4);
		RandomListNode n5 = new RandomListNode(4);
		RandomListNode n6 = new RandomListNode(-3);
		RandomListNode n7 = new RandomListNode(10);
		RandomListNode n8 = new RandomListNode(10);
		RandomListNode n9 = new RandomListNode(10);

	}
}
