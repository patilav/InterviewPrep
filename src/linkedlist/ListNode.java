package linkedlist;

public class ListNode {

	public int data;
	public ListNode next;
	
	public ListNode(){}
	
	public ListNode(int data){
		this.data =  data;
	}
	
	@Override
	public String toString(){
		return String.valueOf(this.data);
	}
}
