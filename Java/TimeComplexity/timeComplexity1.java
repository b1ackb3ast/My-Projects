class timeComplexity1 {
    public static void main (String[] args) {
        timeComplexity1 main = new timeComplexity1();
        int[] customArray = {1, 3, 4, 5};
        main.spofArray(customArray);
    }
    void spofArray(int[] array) {
            int sum = 0;
            int product = 1;
            for (int i = 0; i< array.length; i++){
                sum += array[i];

            }
            for (int i = 0; i< array.length; i++){
                product *= array[i];
            }
            System.out.println(sum+ "," + product);
    }
}