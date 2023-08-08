public class quickSort {
    public int partition(int[] arr, int start, int end) {
    int pivot = end;
    int i = start -1;
        for (int j = start; j<=end; j++) {
            if (arr[j] <= arr[pivot]) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        return i;
    }
    public void quicklySort(int[] array, int start, int end) {
        if (start<end) {
            int pivot = partition(array, start, end);
            quicklySort(array, start, pivot-1);
            quicklySort(array, pivot+1, end);
        }
    }
    public void printArray(int[] array) {
        for (int i=0; i< array.length; i++) {
            System.out.println(array[i] + " ");
        }
    }
    public static void main(String[] args) {
        int[] array = {10, 3, 2, 7, 6, 8, 4, 9};
        quickSort qs = new quickSort();
        qs.quicklySort(array, 0, array.length -1);
        qs.printArray(array);
    }

}
