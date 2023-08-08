public class MergeSort {
    public void mergeSort(int[] inputArray) {
        int length = inputArray.length;

        if (length < 2) {
            return;
        }
        int midIndex = length / 2;
        int [] left = new int[midIndex];
        int [] right = new int[length- midIndex];

        for (int i = 0; i<midIndex; i++) {
            left[i] = inputArray[i];
        }
        for (int i = midIndex; i<length; i++) {
            right[i - midIndex] = inputArray[i];
        }

        mergeSort(left);
        mergeSort(right);

        merge(inputArray, left, right);

    }
    // merge method
    private void merge(int[] inputArray, int[] left, int[] right) {
        int leftSize = left.length;
        int rightSize = right.length;
        int i = 0, j = 0, k = 0;
        // adding elements in order to the input array from the left and the right array
        while (i < leftSize && j < rightSize) {
            if (left[i] <= right[j]) {
                inputArray[k] = left[i];
                i++;
            } else {
                inputArray[k] = right[j];
                j++;
            }
            k++;
        }
        // if there are any leftover elements in the left array
        while (i< leftSize) {
            inputArray[k] = left[i];
            i++;
            k++;
        }
        // if there are any leftover elements in the right array
        while (j< rightSize) {
            inputArray[k] = right[j];
            j++;
            k++;
        }
        


    }
    public void printArray(int[] array) {
        for (int i=0; i< array.length; i++) {
            System.out.println(array[i] + " ");
        }
    }
    public static void main(String[] args) {
        int[] arr = {10, 3, 2, 5, 4, 7, 6, 9, 8, 7};
        MergeSort ms = new MergeSort();
        ms.printArray(arr);
        ms.mergeSort(arr);
        System.out.println();
        ms.printArray(arr);
    }

}