package application;

public class MyDynamicStack {

	private int stackSize;
	private int[] stackArr;
	private int top;
	private String name;

	/**
	 * constructor to create stack with size
	 * 
	 * @param size
	 */
	public MyDynamicStack(int size, String name) {
		this.stackSize = size;
		this.stackArr = new int[stackSize];
		this.top = -1;
		this.name = name;
	}

	public MyDynamicStack() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * This method adds new entry to the top of the stack
	 * 
	 * @param entry
	 * @throws Exception
	 * 
	 */
	public void print() {

		for (int i = top; i >= 0; i--) {
			System.out.println("\t|" + this.stackArr[i] + "|\t\n");
			
		}
		System.out.println("\t"+this.name+"\t\n");
	}

	public void push(int entry) {
		if (this.isStackFull()) {
			System.out.println(("Stack is full! Increasing the capacity.........\n"));
			this.increaseStackCapacity();
		try {
			Thread.sleep(3000);System.out.println("Pushed the data\n");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		// System.out.println("Pushing->> "+entry);
		this.stackArr[++top] = entry;
	}

	/**
	 * This method removes an entry from the top of the stack.
	 * 
	 * @return
	 * @throws Exception
	 */
	public int pop() throws Exception {
		if (this.isStackEmpty()) {
			throw new Exception("Stack is empty. Can not remove element.");
		}
		int entry = this.stackArr[top--];
		System.out.println("Removed entry: "+entry);
		return entry;
	}

	/**
	 * This method returns top of the stack without removing it.
	 * 
	 * @return
	 */
	public long peek() {
		return stackArr[top];
	}

	private void increaseStackCapacity() {

		int[] newStack = new int[this.stackSize * 2];
		for (int i = 0; i < stackSize; i++) {
			newStack[i] = this.stackArr[i];
		}
		this.stackArr = newStack;
		this.stackSize = this.stackSize * 2;
	}

	/**
	 * This method returns true if the stack is empty
	 * 
	 * @return
	 */
	public boolean isStackEmpty() {
		return (top == -1);
	}

	/**
	 * This method returns true if the stack is full
	 * 
	 * @return
	 */
	public boolean isStackFull() {
		return (top == stackSize - 1);
	}

}
