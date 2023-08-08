public class circularDoublyLinkedList {
    public DoublyNode head;
    public DoublyNode tail;
    public int size;
    // creation method of CDLL
    public DoublyNode createCDLL(int nodeValue) {
        head = new DoublyNode();
        DoublyNode node = new DoublyNode();
        node.value = nodeValue;
        head = node;
        tail = node;
        node.next = node;
        node.prev = node;
        size = 1;
        return head;

        
    }
    // insertion method
    public void insertCDLL(int location, int nodeValue) {
        DoublyNode newNode = new DoublyNode();
        newNode.value = nodeValue;
        if (head == null) {
            createCDLL(nodeValue);
        } else if (location == 0) {
            newNode.next = head;
            newNode.prev = tail;
            head.prev = newNode;
            tail.next = newNode;
            head = newNode;
            size++;
            
        } else if (location >= size) {
            newNode.next = head;
            newNode.prev = tail;
            head.prev  = newNode;
            tail.next = newNode;
            tail = newNode;
            size++;

        } else {
            DoublyNode tempNode = new DoublyNode();
            tempNode = head;
            for (int i = 0; i <= location-1; i++) {
                tempNode = tempNode.next;
            }
            newNode.next = tempNode.next.next;
            newNode.next.prev = newNode;
            newNode.prev = tempNode;
            tempNode.next = newNode;
            size++;


        }
    }
    // traversal method
    public void traverseCDLL() {
        if (head == null) {
            System.out.println(" CDLL does not exist!");
            return;
        } else {
            int index = 0;
            DoublyNode tempNode = new DoublyNode();
            tempNode = head;
            while (index != size) {
                System.out.println(tempNode.value);
                if (index != size-1) {
                    System.out.println("->");
                }
                tempNode = tempNode.next;
                index++;
            }
            System.out.println("\n");
        }
    }
    // reverse traversal method
    public void reversetraverseCDLL() {
        if (head == null) {
            System.out.println(" CDLL does not exist!");
            return;
        } else {
            int index = 0;
            DoublyNode tempNode = new DoublyNode();
            tempNode = tail;
            while (index != size) {
                System.out.println(tempNode.value);
                if (index != size-1) {
                    System.out.println("->");
                }
                tempNode = tempNode.prev;
                index++;
            }
            System.out.println("\n");
        }
    }
    // searching method
    public boolean searchingCDLL(int nodeValue) {
        if (head != null) {
            DoublyNode tempNode = new DoublyNode();
            tempNode = head;
            for (int i = 0; i <= size-1; i++) {
                if (tempNode.value == nodeValue) {
                    System.out.println("The value is present at location: " + i);
                    return true;
                } else {
                    tempNode = tempNode.next;
                }
            }
            System.out.println("The value is not present in the circular doubly linked list.");
            return false;

            
        } else {
            System.out.println(" The CDLL does not exist!");
            return false;
        }
    }
    // deletion of node from CDLL
    public void deletenodeCDLL( int location) {
        if (head == null) {
            System.out.println("CDll does not exist!");

        } else if (location == 0) {
            if (size ==1) {
                head = null;
                tail = null;
                
            } else {
                tail.next = head.next;
                head.next.prev = tail;
                head = head.next;
                
            }
            size--;
        } else if (location >= size -1) {
            if (size == 1) {
                head = null;
                tail = null;
                
            } else{
                tail.prev.next = head;
                head.prev = tail.prev;
                tail = tail.prev;
            }
            size--;
        } else {
            int index = 0;
            DoublyNode tempNode = head;
            while (index != location-1) {
                tempNode = tempNode.next;
                index++;
            }
            tempNode.next = tempNode.next.next;
            tempNode.next.next.prev = tempNode;
            size--;
        }
    }
    // deletion of entire CDLL
    public void fulldelete() {
        if (head != null) {
            DoublyNode tempNode = head;
            for (int i = 0; i < size; i++) {
                tempNode.prev = null;
                tempNode = tempNode.next;
            }
            head = null;
            tail = null;
            System.out.println("The CDLL has been deleted!");
        }
    }
    public static void main(String[] args) {
        circularDoublyLinkedList cdll = new circularDoublyLinkedList();
        cdll.createCDLL(3);
        cdll.insertCDLL(1, 5);
        cdll.insertCDLL(2, 6);
        cdll.insertCDLL(3, 7);
        cdll.traverseCDLL();
        cdll.deletenodeCDLL(2);
        cdll.traverseCDLL();

    }


}