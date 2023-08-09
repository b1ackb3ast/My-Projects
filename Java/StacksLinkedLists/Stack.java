public class Stack {
    

    
    LinkedList linkedList = new LinkedList();

    
    // push method
    public void push(int value) {
        linkedList.insertInLinkedList(value, 0);
        System.out.println("Inserted " + value + " in stack successfully!");
    }
    // is Empty method
    public boolean isEmpty() {
        if (linkedList.head == null) {
            return true;
        } else {
            return false;
        }
    }
    // pop method
    public int pop() {
        int result = -1;
        if (isEmpty()) {
            System.out.println("The stack is empty!");

        } else {
            result = linkedList.head.value;
            linkedList.deletionOfNode(0);

        }
        return result;
    }
    // peek method
    public int peek() {
        int result = -1;
        if (isEmpty()) {
            System.out.println("The stack is empty!");

        } else {
            result = linkedList.head.value;
        }
        return result;
    }
    // delete method
    public void deleteStack() {
        linkedList.head = null;
        System.out.println("The stack has been deleted!");
    }
    public static void main(String[] args) {
        Stack newStack = new Stack();
        newStack.push(1);
        newStack.push(2);
        newStack.push(3);
        newStack.deleteStack();

    }
}
