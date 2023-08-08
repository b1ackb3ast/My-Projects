public class Stack {
    int[] arr;
    int topOfStack;

    // create stack method
    public void createStack(int size) {
        this.arr = new int[size];
        this.topOfStack = -1;
        System.out.println("The Stack is created with size of: " + size);
    }
    // is empty method
    public boolean isEmpty() {
        if (topOfStack == -1) {
            return true;
        } else {
            return false;
        }
    }
    // is full method
    public boolean isFull() {
        if (topOfStack == arr.length-1) {
            return true;
        } else {
            return false;
        }
    }
    // Push method
    public void push(int value) {
        if (isFull()) {
            System.out.println("The Stack is full!");

        } else {
            arr[topOfStack + 1] = value;
            topOfStack++;
            System.out.println("The value is successfully inserted!");
        }
    }
    // pop method
    public int pop() {
        if (isEmpty()) {
            System.out.println("The Stack is empty!");
            return -1;
        } else {
            int topStack = arr[topOfStack];
            topOfStack--;
            return topStack;
        }
    }
    // peek method
    public int peek() {
        if (isEmpty()) {
            System.out.println("The stack is empty!");;
            return -1;
        } else {
            return arr[topOfStack];
        }
    }
    // delete method
    public void deleteStack() {
        arr = null;
        System.out.println("The stack is successfully deleted!");
    }
    public static void main(String[] args) {
        Stack newStack = new Stack();
        newStack.createStack(4);
        newStack.push(1);
        newStack.push(2);
        int result = newStack.peek();
        System.out.println(result);
        newStack.deleteStack();
    
        
        } 

}