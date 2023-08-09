public class QueueLinkedList {
    LinkedList list;


    public QueueLinkedList() {
        list = new LinkedList();
        System.out.println("The queue is successfully created!");
    }
    // isEmpty method
    public boolean isEmpty() {
        if (list.head == null) {
            return true;
        } else {
            return false;
        }
    }
    // enQueue method
    public void enQueue(int value) {
        list.insertInLinkedList(value, list.size);
        System.out.println("Successfully inserted " +value+ " into queue!");
        
    }
    // deQueue method
    public int deQueue() {
        int value = -1;
        if (isEmpty()) {
            System.out.println("The queue is empty!");
        } else {
            value = list.head.value;
            list.deletionOfNode(0);

        }
        return value;
    }
    // peek method
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        } else {
            return list.head.value;
        }
    }
    // delete Queue method
    public void deleteQueue() {
        list.head = null;
        list.tail = null;
        System.out.println("the Queue has been deleted1");
    }
    public static void main(String[] args) {
        QueueLinkedList newQLL = new QueueLinkedList();
        newQLL.enQueue(10);
        newQLL.enQueue(20);
        newQLL.enQueue(30);
        newQLL.enQueue(40);
        int result = newQLL.peek();
        System.out.println(result );
        int result1 = newQLL.peek();
        System.out.println(result1);


    }

}
