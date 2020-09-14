
public class queue_linked_list {
	
	private node first, last;
	
	private class node{
		String item;
		node next;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public void enqueue(String item) {
		node oldlast = last; 
		last = new node();
		last.item = item;
		last.next = null;
		if (isEmpty()) {
			first = last;
		}
		else {
			oldlast.next = last;
		}
	}
	
	public String dequeue() {
		String item = first.item;
		first = first.next;
		if(isEmpty()) {
			last = null;
		}
		return item;
	}
	
}
