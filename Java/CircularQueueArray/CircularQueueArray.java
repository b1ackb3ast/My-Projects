
public class CircularQueueArray {
    int[] arr;
    int topOfQueue;
    int beginningOfQueue;
    int size;

    public CircularQueueArray(int size) {
        this.arr = new int [size];
        this.size = size;
        this.topOfQueue = -1;
        this.beginningOfQueue = -1;
        System.out.println("Circular Queue with size " + size + " is created!");
    }
    // isEmpty
    public boolean isEmpty() {
        if (topOfQueue == -1) {
            return true;
        } else {
        return false;
        }

    }
    // is full method
    public boolean isFull() {
        if (topOfQueue +1 == beginningOfQueue) {
            return true;
        } else if (beginningOfQueue ==0 && topOfQueue + 1 ==size) {
            return true;
        } else {
            return false;
        }
    }

    // enQueue method
    public void enQueue(int value) {
       if (isFull()) {
            System.out.println("the CQ is full!");
       } else if (isEmpty()) {
            beginningOfQueue = 0;
            topOfQueue++;
            arr[topOfQueue] = value;
            System.out.println("Successfully inserted "+value+" in the queue.");
       } else {
           if (topOfQueue+1 == size) {
               topOfQueue = 0;
           } else {
               topOfQueue++;
           }
           arr[topOfQueue] = value;
           System.out.println("Successfully inserted "+value+" in the queue.");
       }


    }
    // deQueue
    public int deQueue() {
        if (isEmpty()) {
            System.out.println("The CQ is empty!");
            return -1;
        } else {
            int result = arr[beginningOfQueue];
            arr[beginningOfQueue] = 0;
            if (beginningOfQueue == topOfQueue) {
                beginningOfQueue = topOfQueue = -1;

            } else if (beginningOfQueue+1 == size) {
                beginningOfQueue = 0;
            } else {
                beginningOfQueue++;
            }
            return result;

        }
    }
    // peek method
    public int peek() {
        if (isEmpty()) {
            System.out.println("The CQ is empty!");
            return-1;
        } else {
            return arr[beginningOfQueue];
        }
    }
    // deleteQueue method
    public void deleteQueue() {
        arr = null;
        System.out.println("Queue has been deleted!");
    }
    public static void main(String[] args) {
        CircularQueueArray newCQ = new CircularQueueArray(6);
        newCQ.enQueue(10);
        newCQ.enQueue(20);
        newCQ.enQueue(30);
        newCQ.enQueue(40);
        int result = newCQ.peek();
        System.out.println(result);
    }
}
