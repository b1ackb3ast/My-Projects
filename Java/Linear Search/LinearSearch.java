public class LinearSearch {
    public void linearSearch(int value, int[] arr) {
        for (int i = 0; i<arr.length; i++) {
            if (arr[i] == value) {
                System.out.println(value +" is present in the array at index "+ i);
                return;
            }
        }
        System.out.println("the value is not present in the array");
    }
    
    public static void main(String[] args) {
        int[] array = {10 ,4, 6, 3, 7, 9, 2, 1, 8};
        LinearSearch ls = new LinearSearch();
        ls.linearSearch(6, array);
    }

}