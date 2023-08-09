import java.util.Queue;
import java.util.LinkedList;
public class avlTree {
    BinaryNode root;

    public avlTree() {
        root = null;
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
    // 2 cases for insertion of node, rotation is required and rotation
    // is not required

    // get height method
    public int getHeight(BinaryNode node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }
    // rotate right method
    private BinaryNode rotateRight(BinaryNode disBalancedNode) {
        BinaryNode newRoot = disBalancedNode.left;
        disBalancedNode.left = disBalancedNode.left.right;
        newRoot.right = disBalancedNode;
        disBalancedNode.height = 1 + Math.max(getHeight(disBalancedNode.left), getHeight(disBalancedNode.right));
        newRoot.height = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));
        return newRoot;

    }
    // rotate left method
    private BinaryNode rotateLeft(BinaryNode disBalancedNode) {
        BinaryNode newRoot = disBalancedNode.right;
        disBalancedNode.right = disBalancedNode.right.left;
        newRoot.left = disBalancedNode;
        disBalancedNode.height = 1 + Math.max(getHeight(disBalancedNode.left), getHeight(disBalancedNode.right));
        newRoot.height = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));
        return newRoot;
     }
     // get balance method
     public int getBalance(BinaryNode node) {
         if (node == null) {
         return 0;

        } else {
        return getHeight(node.left) - getHeight(node.right);
        }
     }
     // insertNode Method
     private BinaryNode insertNode(BinaryNode node, int nodeValue) {
        if (node == null) {
            BinaryNode newNode = new BinaryNode();
            newNode.value = nodeValue;
            newNode.height = 1;
            return newNode;
        } else if (nodeValue < node.value) {
            node.left = insertNode(node.left, nodeValue);
        } else {
            node.right = insertNode(node.right, nodeValue);
        }
        node.height = 1 + Math.max(getHeight(node.left),getHeight(node.right));
        int balance = getBalance(node);
        // left left condition
        if (balance > 1 && nodeValue < node.left.value) {
            return rotateRight(node);
        }
        // left right condition
        if (balance > 1 && nodeValue > node.left.value) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }
        // right right condition
        if (balance < -1 && nodeValue > node.right.value) {
            return rotateLeft(node);
        }
        // right left condition
        if (balance < -1 && nodeValue < node.right.value) {
            node.right = rotateRight(node.left);
            return rotateLeft(node);
        }
        return node;

     }
     public void insert(int value) {
         root = insertNode(root, value);
     }

     // minimum node
     public static BinaryNode minimumNode(BinaryNode root) {
         if(root.left == null) {
             return root;
         } else {
             return minimumNode(root.left);
         }
     }
     // Delete node
     private BinaryNode deleteNode(BinaryNode node, int value) {
         // if 
        if (node == null) {
             System.out.println("The value is not found");
             return node;
         }
         // if the value is smaller than the value of the current node
         if (value < node.value) {
             node.left = deleteNode(node.left, value);
        // if the value is greater than the value of the current node
         } else if (value > node.value) {
             node.right = deleteNode(node.right, value);
        // if the value is the same as the value in the current node
         } else {
        // if the node to be deleted has 2 child nodes
            if (node.left != null && node.right != null) {
                 BinaryNode temp = node;
                 BinaryNode minimumNodeForRight = minimumNode(temp.right);
                 node.value = minimumNodeForRight.value;
                 node.right = deleteNode(node.right, minimumNodeForRight.value);
            // if node to be deleted has 1 child node on the left
             } else if (node.left != null) {
                 node = node.left;
            
            // if node to be deleted has 1 child node on the right
             } else if (node.right != null) {
                node = node.right;

            // if node to be deleted does not have any nodes
             } else {
                 node = null;
             }
         }
         // check if node is balanced of not
         int balance = getBalance(node);
         // if node is not balanced:
         if (balance >1 && getBalance(node.left)>=0) {
             return rotateRight(node);
         } if (balance > 1 && getBalance(node.left)<0) {
             node.left = rotateLeft(node.left);
             return rotateRight(node);
         } if (balance < -1 && getBalance(node.right)<=0) {
            return rotateLeft(node);
        } if (balance < -1 && getBalance(node.right)>0) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }
        return node;
     }

     public void delete(int value) {
         root = deleteNode(root, value);
     }
     public void deleteAVl() {
         root = null;
         System.out.println("The avl tree has been deleted!");
     }
     public static void main(String[] args) {
        avlTree avl = new avlTree();
        avl.insert(5);
        avl.insert(10);
        avl.insert(15);
        avl.insert(20);
        avl.insert(25);
        avl.levelOrder();
        avl.delete(10);
        System.out.println();
        avl.levelOrder();
        
        
    }
}


