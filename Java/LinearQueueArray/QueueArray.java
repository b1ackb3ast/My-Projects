
public class QueueArray {
    int[] arr;
    int topOfQueue;
    int beginningOfQueue;

    public QueueArray(int size) {
        this.arr = new int[size];
        this.topOfQueue = -1;
        this.beginningOfQueue = -1;
        System.out.println("The Queue is sucessfully created with size of: " + size);

    }
    // isFull method
    public boolean isFull() {
        if (topOfQueue == arr.length-1) {
            return true;

        } else {
            return false;
        }
    }
    //isEmpty method
    public boolean isEmpty() {
        if (beginningOfQueue == -1 || beginningOfQueue == arr.length) {
            return true;
        } else {
            return false;
        }
    }
    // enQueue method
    public void enQueue(int value) {
        if (isFull()) {
            System.out.println("The queue is full!");

        } else if (isEmpty()){
            beginningOfQueue = 0;
            topOfQueue++;
            arr[topOfQueue] = value;
            System.out.println("Value " + value + " successfully inserted to the queue!");
        } else {
            topOfQueue++;
            arr[topOfQueue] = value;
            System.out.println("Value " + value + " successfully inserted to the queue!");
            
        }
    }
    // deQueue method
    public int deQueue() {
        if (isEmpty()) {
            System.out.println(" The queue is empty!");
            return -1;
        } else {
            int result = arr[beginningOfQueue];
            beginningOfQueue++;
            if(beginningOfQueue > topOfQueue) {
                beginningOfQueue = topOfQueue = -1;
            }
            return result;
        }
    }

    // peek method
    public int peek() {
        if (!isEmpty()) {
        return arr[beginningOfQueue];

        } else {
            System.out.println(" The queue is empty!");
            return -1;

        }
        
    }
    // delete method
    public void deleteQueue() {
        arr = null;
        System.out.println("Queue is successfully deleted!");
    }
    public static void main(String[] args) {
        QueueArray newQueue = new QueueArray(5);
        newQueue.enQueue(1);
        newQueue.enQueue(2);
        newQueue.enQueue(3);
        newQueue.enQueue(4);
        newQueue.enQueue(5);
        int result = newQueue.peek();
        System.out.println(result);
        newQueue.deleteQueue();
        
    }

}
