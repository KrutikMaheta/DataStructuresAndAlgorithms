package basic;

public class TwoStacksClient {

	public static void main(String[] args) throws Exception {
		TwoStacks ts = new TwoStacks(5);
		ts.push1(5);
		ts.push2(10);
		ts.push2(15);
		ts.push1(11);
		ts.push2(7);
		System.out.println("Popped element from" + " stack1 is " + ts.pop1());
		System.out.println("Popped element from" + " stack1 is " + ts.pop1());
		//ts.push2(40);
		System.out.println("Popped element from" + " stack2 is " + ts.pop2());
		System.out.println("Popped element from" + " stack2 is " + ts.pop2());
		System.out.println("Popped element from" + " stack2 is " + ts.pop2());
	}

}
