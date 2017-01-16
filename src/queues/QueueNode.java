package queues;

public class QueueNode {

	int data;
	QueueNode next;
	
	public QueueNode(){}
	
	public QueueNode(int data){
		this.data =  data;
	}
	
	@Override
	public String toString(){
		return String.valueOf(this.data);
	}
}
