package basic;

public class LinkedStackClient {

	public static void main(String[] args) {
		LinkedStack<Integer> stack = new LinkedStack<Integer>();
		System.out.println(stack);
		stack.push(5);
		stack.push(3);
		stack.push(1);
		stack.push(10);
		System.out.println(stack);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		// Throws exception as the stack is empty at this point of time
	//	System.out.println(stack.pop());
		
		
		LinkedStack<Character> charStack = new LinkedStack<Character>();
		System.out.println(charStack);
		charStack.push('5');
		charStack.push('3');
		charStack.push('1');
		charStack.push('a');
		System.out.println(charStack);
		System.out.println(charStack.pop());
		System.out.println(charStack.pop());
		System.out.println(charStack.pop());
		System.out.println(charStack.pop());
	}

}
