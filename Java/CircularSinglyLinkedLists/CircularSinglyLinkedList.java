

public class CircularSinglyLinkedList {
    // head and tail references
    public Node head;
    public Node tail;
    public int size;
    // creation of circular singly linked list
    public Node createCSLL(int nodeValue) {
        head = new Node();
        Node node = new Node();
        node.value = nodeValue;
        node.next = node;
        // head and tail references has to point to this newly 
        // created node
        head = node;
        tail = node;
        size = 1;
        return head;
    }
    // insertion in circular singly linked list
    public void insertCSLL(int nodeValue, int location) {
        // check if linked list exists or not. if it does then 
        // create new node and assign value. if not then terminate
        Node node = new Node();
        node.value = nodeValue;
        
        if (head == null) {
           createCSLL(nodeValue);
           return;
        } // inserting node at the beginning of CSLL
        else if (location == 0) {
            node.next = head;
            head = node;
            tail.next = head;

        } // inserting node at end of CSLL
        else if (location >= size) {
            tail.next = node;
            tail = node;
            tail.next = head;


        } // inserting node somewhere in the middle of the CSLL
        else {
            Node tempNode = head;
            int index = 0;
            while (index < location -1) {
                tempNode = tempNode.next;
                index++;
            }
            node.next = tempNode.next;
            tempNode.next = node;

        }
        size++;
    }
    // Traversal method
    public void traverseCSLL() {
        if (head !=null) {
            Node tempNode = head;
            for (int i=0; i < size; i++) {
                System.out.println(tempNode.value);
                if (i != size -1) {
                    System.out.println(" -> ");
                }
                tempNode = tempNode.next;
            }
        System.out.println("\n");
        } else {
            System.out.println("\nCSLL does not exist! ");
        }
        
    }
    // Search method
    public boolean searchNode(int nodeValue) {
        if (head != null) {
            Node tempNode = head;
            for (int i = 0; i < size; i++) {
                if (tempNode.value == nodeValue) {
                System.out.println("Found node at location: "+ i);
                return true;
                }
                tempNode = tempNode.next;
            }
        }
            System.out.println("Node not found! ");
            return false;
        
    }
    // Deletion method
    public void deleteNode(int location) {
        if (head == null) {
            System.out.println("The CSLL does not exist!");
            return;

        } else if (location == 0 ) {
            head = head.next;
            tail.next = head;
            size--;
            if (size ==0 ){
                tail = null;
                head = null;
                head.next = null;
            }
        } else if (location >= size) {
            Node tempNode = head;
            for (int i = 0; i< size-1; i++) {
                tempNode = tempNode.next;
            }
            if (tempNode == head) {
                head.next = null;
                tail = head = null;
                size--;
                return;
            }
            tempNode.next = head;
            tail = tempNode;
            size--;
        } else {
            Node tempNode = head;
            for (int i=0; i < location-1; i++) {
                tempNode = tempNode.next;
            }
            tempNode.next = tempNode.next.next;
            size--;


        }
    
    }
    //Delete CSLL
    public void deleteCSLL() {
        if (head == null) {
        System.out.println("The CSLL does not exist");

        } else {
            head = null;
            tail.next = null;
            tail = null;
            System.out.println("The CSLL has been deleted");
        }
    }
    public static void main(String[] args) {
        CircularSinglyLinkedList csll = new CircularSinglyLinkedList();
        csll.createCSLL(5);
        csll.insertCSLL(4, 1);
        csll.insertCSLL(6, 2);
        csll.insertCSLL(7, 3);
        csll.traverseCSLL();
        csll.deleteNode(2);
        csll.traverseCSLL();
    }

    
    
}
