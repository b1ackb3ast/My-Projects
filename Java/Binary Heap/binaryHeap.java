public class binaryHeap {
    int arr[];
    int sizeOfTree;

    public binaryHeap(int size) {
        arr = new int[size + 1];
        this.sizeOfTree = 0;
        System.out.println("Binary Heap has been created!");
    }
    // isEmpty method
    public boolean isEmpty() {
        if(sizeOfTree == 0) {
            return true;
        }
        else {
            return false;
        }
    }
    // peek method to find root of binary heap
    public Integer peek() {
        if(isEmpty()) {
            System.out.println("Binary Heap is empty!");
            return null;

        }
        return arr[1];

    }
    // size of tree method
    public int size() {
        return sizeOfTree;
    }
    //traversal of binary heap;
    public void traversalLevelOrder() {
        if(isEmpty()) {
            System.out.println("Binary Heap is empty!");
        }
        else{
            for (int i = 1; i <=sizeOfTree; i++) {
                System.out.println(arr[i] + " ");
            }
            System.out.println("\n");
        }
        
    }
    // heapify for insert method
    public void heapifyBottomToTop(int index, String heapType) {
        int parent = index / 2;
        if (index <= 1) {
            return;
        }
        if (heapType == "Min") {
            if (arr[index] < arr[parent]) {
                int tmp = arr[index];
                arr[index] = arr[parent];
                arr[parent] = tmp;
            }

        } else if (heapType == "Max") {
            if (arr[index] > arr[parent]) {
                int tmp = arr[index];
                arr[index] = arr[parent];
                arr[parent] = tmp;
            }
        }

        heapifyBottomToTop(parent, heapType);

    }
    // insert method for binary heap
    public void insert(int value, String heapType) {
        arr[sizeOfTree + 1] = value;
        sizeOfTree++;
        heapifyBottomToTop(sizeOfTree, heapType);
        System.out.println("Inserted " + value + " successfully in heap!");
    }
    // heapifyTopToBottom (can only extract root node)
    public void heapifyTopToBottom(int index, String heapType) {
        int left = index*2;
        int right = index*2 + 1;
        int swapChild = 0;
        if (sizeOfTree < left) {
            return;
        }
        // if it is a max heap
        if (heapType == "Max") {
        // if left is the only child
            if (sizeOfTree == left) {
                if (arr[index] < arr[left]) {
                    int tmp = arr[index];
                    arr[index] = arr[left];
                    arr[left] = tmp;
                }
                return;
        //there is both left and right children
            } else {
                if (arr[left] > arr[right]) {
                swapChild = left;
                }
                else {
                    swapChild = right;
                }
                if (arr[index] < arr[swapChild]){
                    int tmp = arr[index];
                    arr[index] = arr[swapChild];
                    arr[swapChild] = tmp;
                }
            }
        } else if (heapType == "Min") {
            // if left is the only child
            if (sizeOfTree == left) {
                if (arr[index] > arr[left]) {
                    int tmp = arr[index];
                    arr[index] = arr[left];
                    arr[left] = tmp;
                }
                return;
            //there is both left and right children
            } else {
                if (arr[left] < arr[right]) {
                swapChild = left;
                } else {
                    swapChild = right;
                }
                if (arr[index] > arr[swapChild]){
                    int tmp = arr[index];
                    arr[index] = arr[swapChild];
                    arr[swapChild] = tmp;
                }
            }
        }
        heapifyTopToBottom(swapChild, heapType);
    }
    // extract node from binary heap (only head)
    public int extractHeadOFBH(String heapType){
        if (isEmpty()) {
            return -1;
        } else {
            int extractedValue = arr[1];
            arr[1] = arr[sizeOfTree];
            sizeOfTree--;
            heapifyTopToBottom(1, heapType);
            return extractedValue;
        }
    }
    public void deleteFullBinaryHeap() {
        arr = null;
        System.out.println("The binary heap has been deleted!");
        return;
    }
    public static void main(String[] args) {
        binaryHeap binaryHeap = new binaryHeap(5);
        binaryHeap.insert(10, "Min");
        binaryHeap.insert(15, "Min");
        binaryHeap.insert(5, "Min");
        binaryHeap.insert(1, "Min");
        binaryHeap.traversalLevelOrder();
        binaryHeap.extractHeadOFBH("Min");
        binaryHeap.traversalLevelOrder();
        binaryHeap.deleteFullBinaryHeap();
    }
}
