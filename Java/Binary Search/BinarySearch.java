public class BinarySearch {
    public void binarySearch(int[] arr, int value) {
        int start = 0;
        int end = arr.length-1;
        int middle = (start + end) /2;
        while (arr[middle] != value && start< end ) {
            if (value < arr[middle]) {
                end = middle -1;
            }
            else {
                start = middle + 1;
            }
            middle = (start+end)/2;
        }
        if (arr[middle] == value) {
            System.out.println(value +" found at index "+ middle);
        } else {
            System.out.println(value+ " does not exist in the array");
        }

        
    }
    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        int[] arr = {8, 5, 3, 9, 7, 10, 2, 6, 1};
        QuickSort qs = new QuickSort();
        qs.quicklySort(arr, 0, arr.length-1);
        qs.printArray(arr);
        bs.binarySearch(arr, 8);
        
    }
}
