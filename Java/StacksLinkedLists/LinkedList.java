public class LinkedList {
    public Node head;
    public Node tail;
    public int size;

    public Node createSinglyLinkedList(int nodeValue) {
        head = new Node();
        
        // to make the node object from the Node class
        Node node = new Node();
        node.next = null;
        node.value = nodeValue;
        head = node;
        tail = node;
        size = 1;

        return head;
    }
    // Insert Method SinglyLinkedList
    public void insertInLinkedList(int nodeValue, int location) {
        Node node = new Node();
        node.value = nodeValue;
        // If linked list does not exist, singly linked list with one node will
        // be created in memory
        if (head == null) {
            createSinglyLinkedList(nodeValue);
            return;
        // Insert node at the start of linked list
        } else if (location == 0) {
            node.next = head;
            head = node;
            
        // Insert node at the end of linked list
        } else if (location >= size) {
            node.next = null;
            tail.next = node;
            tail = node;
        // Insert node somewhere in the middle of the list
        } else { 
            Node tempNode = head;
            int index = 0;
            while (index < location -1) {
                tempNode = tempNode.next;
                index++;
            }
            Node nextNode = tempNode.next;
            tempNode.next = node;
            node.next = nextNode;
        }
        size++;

    }
    // SinglyLinkedList Traversal
    public void traverseSinglyLinkedList() {
        if (head == null) {
            System.out.println("Singly linked list does not exist.");

        } else {
            Node tempNode = head;
            for (int i = 0; i<size; i++) {
                System.out.println(tempNode.value);
                if (i != size - 1) {
                    System.out.println(" -> ");

                }
                tempNode = tempNode.next;

            }
            
        }
        System.out.println("\n");
    }

    // Search for a node
    boolean searchSinglyLinkedList(int nodeValue) {
        if (head != null) {
            Node tempNode = head;
            for (int i = 0; i<size; i++) {
                if (tempNode.value == nodeValue) {
                    System.out.println("Found the node at location: " +i+ "\n");
                    return true;
                }
                tempNode = tempNode.next;
            }
            
        }
        System.out.println("Node not found! ");
        return false;
    }

    //Deleting a node from SinglyLinkedList
    public void deletionOfNode(int location) {
        if (head == null) {
            System.out.println("The singly linked list does not exist");
            return;
        } else if (location == 0) {
            head = head.next;
            size--;
            if (size == 0) {
                tail = null;
            }
        } else if (location >= size) {
            Node tempNode = head;
            for (int i = 0; i < size -1; i++) {
                tempNode = tempNode.next;
            }
            if (tempNode == head) {
                tail = head = null;
                size--;
                return;
            }
            tempNode.next = null;
            tail = tempNode;
            size--;
        } else {
            Node tempNode = head;
            for (int i = 0; i< location -1; i++) {
                tempNode = tempNode.next;
            }
            tempNode.next = tempNode.next.next;
            size--;
        }
    }
    // Delete Entire SinglyLinkedList
    public void deletesLL() {
        head = null;
        tail = null;
        System.out.println(" the sll is deleted sucessfully");
    }
    

}


