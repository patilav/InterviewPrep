package linkedlist;

import java.util.Stack;

public class TwoSumForwardList {
	
	public int carry = 0;
	public ListNode res = null;
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		
		if(l1 == null){
			return l2;
		}
		
		if(l2 == null){
			return l1;
		}
		
		//Get length
		int l1Length = getLength(l1);
		int l2Length = getLength(l2);
		
		if(l1Length>l2Length){
			l2 = fillZeroes(l2, l1Length - l2Length);
		} else if(l1Length<l2Length){
			l1 = fillZeroes(l1, l2Length - l1Length);
		}
		

		ListNode res = calculateSum(l1, l2);
		
		if(carry > 0){
			ListNode temp = new ListNode(carry);
			temp.next = res;
			res = temp;
		}
		
		return res;
	}
	
	public ListNode calculateSum(ListNode l1, ListNode l2){
		if(l1 == null || l2 == null){
			return null;
		}
		calculateSum(l1.next, l2.next);
		
		//calculate sum
		int sum = carry + l1.data + l2.data;
		
		//update carry
		carry = (sum >= 10) ? 1 : 0;
		
		//update sum
		sum = sum %10;
		
		ListNode temp = new ListNode(sum);
		
		if(res == null){
			res = temp;
		} else{
			temp.next = res;
			res = temp;
		}
		
		return res;
	}
	
	public void printList(ListNode current) {

		while (current != null) {
			System.out.print(current + " ");
			current = current.next;
		}
		System.out.println();
	}
	
	
	public int getLength(ListNode l){
        int length = 0;
        
        while(l!=null){
        	length++;
        	l = l.next;
        }
        
        return length;
    }
	
	public ListNode fillZeroes(ListNode l, int diff){
		
		for(int i=0; i<diff;i++){
			ListNode temp = new ListNode(0);
			temp.next = l;
			l = temp;
		}
		
		return l;
	}
	
	public ListNode addTwoNumbersStack(ListNode l1, ListNode l2) {
		ListNode res = null;
		Stack<Integer> sl1 = new Stack<>();
		Stack<Integer> sl2 = new Stack<>();
		
		//Push all the elements on the stack
		while(l1 !=null){
			sl1.push(l1.data);
			l1 = l1.next;
		}
		
		while(l2 !=null){
			sl2.push(l2.data);
			l2 = l2.next;
		}
		
		int carry = 0;
		while(!sl1.isEmpty() || !sl2.isEmpty()){
			int sum = 0;
			if(!sl1.isEmpty()){
				sum = sum + sl1.pop();
			}
			
			if(!sl2.isEmpty()){
				sum = sum + sl2.pop();
			}
			//add the carry
			sum = sum + carry;
			
			//update carry
			carry = (sum >= 10) ? 1 : 0;
			
			//update sum
			sum = sum %10;
			
			ListNode temp = new ListNode(sum);
			
			if(res == null){
				res = temp;
			} else{
				temp.next = res;
				res = temp;
			}
		}
		
		if(carry > 0){
			ListNode temp = new ListNode(carry);
			temp.next = res;
			res = temp;
		}
		
		return res;
	}
	
	public static void main(String args[]){
		TwoSumForwardList tsfl = new TwoSumForwardList();
		
		LinkedList list1 = new LinkedList();
		list1.insert(1);
		list1.insert(2);
		list1.insert(3);
		list1.insert(4);
		
		LinkedList list2 = new LinkedList();
		list2.insert(1);
		list2.insert(2);
		list2.insert(3);
		
		ListNode res = tsfl.addTwoNumbersStack(list1.head, list2.head);
		tsfl.printList(res);
	}
}
