public class BinaryTreeArray {
    String [] arr;
    int lastUsedIndex;
    public BinaryTreeArray(int size) {
        arr = new String[size + 1];
        this.lastUsedIndex = 0;
        System.out.println("Blank tree of size " +size+ " has been created!");
    }
    // method to check if tree is full
    boolean isFull() {
        if (arr.length-1 == lastUsedIndex) {
            return true;
        } else {
            return false;
        }
    }
    // insert node into a binary tree method
    public void insert(String value) {
        if (!isFull()) {
            arr[lastUsedIndex+1] = value;
            lastUsedIndex++;
            System.out.println("The value of " +value+ " is inserted!");

        } else { 
            System.out.println("THe BT is full!");
        }
    }
    // preorder traversal
    public void preOrder(int index) {
        if (index > lastUsedIndex) {
            return;
        }
        System.out.println(arr[index]+" ");
        preOrder(index * 2);
        preOrder((index * 2) + 1);
    }
    // inorder traversal method
    public void inOrder(int index) {
        if (index > lastUsedIndex) {
            return;
        }
        
        inOrder(index * 2);
        System.out.println(arr[index]+" ");
        inOrder((index * 2) + 1);
    }
    public void postOrder(int index) {
        if (index > lastUsedIndex) {
            return;
        }
        // post order traversal method
        postOrder(index * 2);
        postOrder((index * 2) + 1);
        System.out.println(arr[index]+" ");
    }
    // level order traversal method
    public void levelOrderTraversal() {
        for (int i = 1; i<=lastUsedIndex; i++) {
            System.out.println(arr[i]+ " ");
        }
    }
    // level order search method
    public int levelOrderSearch(String value) {
        for (int i = 1; i<=lastUsedIndex; i++) {
            if (arr[i] == value) {
                System.out.println("The value "+value+" is located at "+i);
                return 1;
            }
        }
        System.out.println("the value does not exist!");
        return -1;
    
    }
    // delete method
    public void delete(String value) {
        int location = levelOrderSearch(value);
        if (location == -1) {
        return;
        } else {
            arr[location] = arr[lastUsedIndex];
            lastUsedIndex--;
            System.out.println("The node is successfully deleted!");
        }
    }
    // delete full binary tree array
    public void deleteBT() {
        try {
            arr = null;
            System.out.println("The binary tree has been successfully deleted.");
        } catch (Exception e) {
            System.out.println("There was an error deleting the tree.");
        }

    }
    public static void main(String[] args) {
        BinaryTreeArray binaryTree = new BinaryTreeArray(9);
        binaryTree.insert("N1");
        binaryTree.insert("N2");
        binaryTree.insert("N3");
        binaryTree.insert("N4");
        binaryTree.insert("N5");
        binaryTree.insert("N6");
        binaryTree.insert("N7");
        binaryTree.insert("N8");
        binaryTree.insert("N9");
        System.out.println();

        binaryTree.delete("N3");
        
    }

}
