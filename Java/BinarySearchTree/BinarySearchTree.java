import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    BinaryNode root;

    public BinarySearchTree() {
        root = null;
    }
    //  insert Method
    private BinaryNode insert(BinaryNode currentNode, int value) {
        if (currentNode == null) {
            BinaryNode newNode = new BinaryNode();
            newNode.value = value;
            System.out.println("The value "+newNode.value+" is successfully inserted.");
            return newNode;
        } else if (value <= currentNode.value) {
            currentNode.left =  insert(currentNode.left, value);
            return currentNode;
        } else {
           currentNode.right = insert(currentNode.right, value);
           return currentNode;
        }
        
        
    }
    // main insert method
    public void insert(int value) {
        root = insert(root, value);

    }
    // preOrder traversal
    public void preOrder(BinaryNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.value+ " ");
        preOrder(node.left);
        preOrder(node.right);
    }
    // inOrder Traversal
    public void inOrder(BinaryNode node) {
        if (node == null) {
            return;
        }
        
        inOrder(node.left);
        System.out.println(node.value);
        inOrder(node.right);
    }
    // postOrder traversal
    public void postOrder(BinaryNode node) {
        if (node == null) {
            return;
        }
        
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.value);
    }
    // level order traversal for binary search tree
    public void levelOrder() {
        Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
        queue.add(root);
        while(!queue.isEmpty()) {
            BinaryNode presentNode = queue.remove();
            System.out.println((presentNode.value + " "));
            if (presentNode.left != null) {
                queue.add(presentNode.left);
            }
            if (presentNode.right != null) {
                queue.add(presentNode.right);
            }
            
        }
              
    }
    // search method for binary search tree
    public void search(int value) {
        Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
        queue.add(root);
        
        while(!queue.isEmpty()) {
            BinaryNode presentNode = queue.remove();
            if (presentNode.value == value) {
                System.out.println("The value "+value+" is present in the binary tree!");
                return;
            
            } else if (presentNode.left!= null && value <= presentNode.value) {
                queue.add(presentNode.left);

            } else if (presentNode.right != null && value > presentNode.value ) {
                queue.add(presentNode.right);
            }
        }
        System.out.println(value+" does not exist in the binary tree!");
    }
    // search method through recursion
    public BinaryNode search1(BinaryNode node, int value) {
        if (node == null) {
            System.out.println("Value! "+value+" not found in BST");
            return null;
        } else if (node.value == value) {
            System.out.println("Value: "+value+" found in BST");
            return node;
        
        } else if (value < node.value) {
            return search1(node.left, value);

        } else {
            return search1(node.right, value);
        }
    }
    // Minimum node
    public BinaryNode minimumNode(BinaryNode root) {
            if (root.left == null) {
                return root;
            } else {
                return minimumNode(root.left);
            }

    }
    // Delete node method for binary search tree
    public BinaryNode deleteNode(BinaryNode root, int value) {
        // if the node.value does not exist (base case of recursion)
        if (root == null) {
            System.out.println("Value not found in BSI");
            return null;
        }// if the value is smaller than the root node value
        if (value < root.value) {
            root.left = deleteNode(root.left, value);
        }// if the value is greater than the root node value 
        else if (value > root.value) {
            root.right = deleteNode(root.right, value);
            
        } else {
            // if both left and right childs are not null so we find
            // the next biggest value to replace the root node with so
            // the minNodeForRight variable is created for that.
            if (root.left != null && root.right != null) {
                    BinaryNode temp = root;
                    BinaryNode minNodeForRight = minimumNode(temp.right);
                    root.value = minNodeForRight.value;
                    root.right = deleteNode(root.right, minNodeForRight.value);

            }// if only the left child is not null, replace root with root.left
             else if (root.left != null) {
                root = root.left;

            }// if only the right child is not null, replace root with root.right
            else if (root.right != null) {
                root = root.right;

            }// if there are no children
            else {
                root = null;
            }
        }
        return root;
    }
    // binary search tree delete full tree
    public void deleteBST() {
        root = null;
        System.out.println("The BST has been deleted!");
    }
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(70);
        bst.insert(50);
        bst.insert(90);
        bst.insert(30);
        bst.insert(60);
        bst.insert(80);
        bst.insert(100);
        bst.insert(20);
        bst.insert(40);
        bst.levelOrder();
        bst.deleteBST();
        bst.levelOrder();
        
        
    }




} 
