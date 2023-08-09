public class Main { 

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