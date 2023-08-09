public class heapSort {
    int[] arr = null;
    public heapSort(int[] arr) {
        this.arr = arr;
    }

    public void sort() {
        binaryHeap bh = new binaryHeap(arr.length);
        for (int i =0; i<arr.length; i++) {
            bh.insert(arr[i], "Min");
        }
        for (int i=0; i<arr.length;i++) {
            arr[i] = bh.extractHeadOFBH("Min");
        }
    }



    public void printArray() {
        for(int i  = 0; i <arr.length; i++) {
            System.out.println(arr[i]+ " ");
        }
    }
    public static void main(String[] args) {
        int[] arr = {10, 8, 3, 4, 7, 5, 6, 2, 9};
        heapSort hs = new heapSort(arr);
        hs.sort();
        hs.printArray();

    }
}
