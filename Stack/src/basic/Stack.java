package basic;

public interface Stack {
	public boolean isEmpty();

	public int size();

	public void push(int data) throws Exception;

	public int top() throws Exception;

	public int pop() throws Exception;
}
