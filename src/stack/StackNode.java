package stack;

public class StackNode {

	int data;
	StackNode next;
	
	public StackNode(){}
	
	public StackNode(int data){
		this.data =  data;
	}
	
	@Override
	public String toString(){
		return String.valueOf(this.data);
	}
}
