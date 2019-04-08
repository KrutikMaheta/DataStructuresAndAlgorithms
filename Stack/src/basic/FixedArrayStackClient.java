package basic;

public class FixedArrayStackClient {

	public static void main(String[] args) throws Exception {
		FixedArrayStack stack = new FixedArrayStack(5);

		System.out.println(stack);
		stack.push(5);
		stack.push(3);
		stack.push(2);
		stack.push(1);
		stack.push(7);

		System.out.println(stack.size());
		System.out.println("Inspect the top : " + stack.top());
		System.out.println(stack.size());
		System.out.println(stack);

		// Will throw stack over flow exception as the stack is full
		// stack.push(7);

		System.out.println("Popping the elements ");
		int initialSize = stack.size();
		for (int i = 0; i < initialSize; i++)
			System.out.println(stack.pop());

		// Will throw stack under flow exception as the stack is empty
		// stack.pop();
	}

}
