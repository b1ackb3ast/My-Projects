public class recursionProb4 {
    // function that converts decimal to binary
    public static void main(String[] args) {
        recursionProb4 main = new recursionProb4();
        var result = main.decimalToBinary(10);
        System.out.println(result);
    }
    public int decimalToBinary(int n) {
        if (n == 0){
            return 0;
        }
        return n % 2 + 10 * decimalToBinary(n/2);
    }
}