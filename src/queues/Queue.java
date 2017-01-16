package queues;

public class Queue {

	QueueNode first;
	QueueNode last;

	public void enqueue(int data) {
		QueueNode node = new QueueNode(data);

		if(last != null){
			last.next = node;
		}
		last = node;
		
		if(first == null){
			first = last;
		}
	}

	public QueueNode dequeue() {
		if(first == null) return null;
		
		QueueNode node = first;
		
		first = first.next;
		if(first == null){
			last = null;
		}
		return node;
	}

	public boolean isEmptyQueue() {
		return first == null;
	}

	public static void main(String args[]) {
		Queue queue = new Queue();

		queue.enqueue(5);
		queue.enqueue(6);
		queue.enqueue(7);
		queue.enqueue(8);
		queue.enqueue(9);

		while (!queue.isEmptyQueue()) {
			System.out.println(queue.dequeue());
		}
	}

}
