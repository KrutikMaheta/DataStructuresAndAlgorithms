package basic;

public class ArrayQueue implements Queue {
	int capacity, front, rear, size;
	int arr[];

	public ArrayQueue(int capacity) {
		this.capacity = capacity;
		arr = new int[capacity];
		rear = capacity - 1;
		front = 0;
		size = 0;
	}

	public void enqueue(int data) throws Exception {
		if (isFull())
			throw new Exception("Queue is overflowed");
		rear = (rear + 1) % capacity;
		arr[rear] = data;
		size += 1;
	}

	public int dequeue() throws Exception {
		if (isEmpty())
			throw new Exception("Queue is underflowed");
		int data = arr[front];
		front = (front + 1) % capacity;
		size -= 1;
		return data;
	}

	public int front() {
		if (isEmpty())
			return Integer.MIN_VALUE;

		return this.arr[this.front];
	}

	public int rear() {
		if (isEmpty())
			return Integer.MIN_VALUE;

		return arr[rear];
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean isFull() {
		return size == capacity;
	}

}
