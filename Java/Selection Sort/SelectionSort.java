public class SelectionSort {
    public void selectionSort(int a[]) {
        for (int j = 0; j<a.length; j++) {
            int minimumIndex = j;
            for (int i = j+1; i<a.length; i++) {
                if (a[i] < a[minimumIndex]) {
                    minimumIndex = i;
                }
            }
            if (minimumIndex != j) {
                int temp = a[j];
                a[j] = a[minimumIndex];
                a[minimumIndex] = temp;
        }
        
        }
    }
    public void printArray(int arr[]) {
        for(int i = 0; i<arr.length; i++) {
            System.out.println(arr[i] + " ");
        }
    }
    public static void main(String[] args) {
        int a[] = {10, 3, 2, 5, 8, 4, 1, 9};
        SelectionSort ss  = new SelectionSort();
        ss.selectionSort(a);
        ss.printArray(a);
    }
}
    
