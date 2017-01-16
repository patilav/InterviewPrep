package linkedlist;

public class ReverseLinkedList {

	public static ListNode reverseList(ListNode head){
		
		if(head == null){
			return head;
		}
		
		ListNode prev = null;
		ListNode current = head;
		ListNode next = head.next;
		
		while(next != null){
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		
		head = prev;
		
		return head;
	}
	
	public static void printList(ListNode head) {

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
	
	public static ListNode reverseDeepCopy(ListNode head){
		
		if(head == null){
			return null;
		}
		
		//Create a head for the list
		ListNode newHead = new ListNode(head.data);
		//loop from head.next to end of list and append the node at front
		ListNode current = head.next;
		while(current != null){
			ListNode next = new ListNode(current.data);
			next.next = newHead;
			newHead = next;
			current = current.next;
		}
		return newHead;
	}
	
	public static void main(String args[]){
		ListNode head = new ListNode(10);
		head.next = new ListNode(20);
		head.next.next = new ListNode(30);
		head.next.next.next = new ListNode(40);
		head.next.next.next.next = new ListNode(50);
		
		ListNode newHead = reverseDeepCopy(head);
		System.out.println("Original list");
		printList(head);
		System.out.println("Reversed list");
		printList(newHead);
	}
}
