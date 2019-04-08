package basic;

public interface Queue {
	public void enqueue(int data) throws Exception;

	public int dequeue() throws Exception;

	public int front();

	public int rear();

	public boolean isEmpty();

	default public boolean isFull() {
		System.out.println("Not required in every implementation");
		return false;
	}
}
