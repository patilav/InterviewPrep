package stack;
	
public class Stack {

	public StackNode top;

	public StackNode push(int data) {
		StackNode newNode = new StackNode(data);
		newNode.next = top;
		top = newNode;
		return top;
	}

	public StackNode pop() {
		if (!isEmptyStack()) {
			StackNode popped = top;
			top = top.next;
			popped.next = null;
			return popped;
		}
		return null;
	}

	public boolean isEmptyStack() {
		return top == null;
	}
	
	public void printStack(){
		System.out.println("Printing Start");
		while (this.top != null) {
			System.out.println(this.pop());
		}
		System.out.println("Printing end");
	}
	
	public int peek(){
		if(this.top != null){
			return top.data;
		}
		return -1;
	}
	
	public void sortStack(){
		
		Stack sorted = this;
		Stack buffer = new Stack();
		
		while(!sorted.isEmptyStack()){
			int temp = sorted.pop().data;
			
			while(!buffer.isEmptyStack() && buffer.peek()< temp){
				int data = buffer.pop().data;
				sorted.push(data);
			}
			//This will create a reverse sorted stack
			buffer.push(temp);
		}
		
		while(!buffer.isEmptyStack()){
			int data = buffer.pop().data;
			sorted.push(data);
		}
	}

	public static void main(String args[]) {
		Stack s = new Stack();
		s.push(5);
		s.push(6);
		s.push(7);
		s.push(8);
		s.push(3);
		s.push(2);
		
		//2,3,8,7,6,5
		
		s.sortStack();
		
		s.printStack();

		
	}
}
