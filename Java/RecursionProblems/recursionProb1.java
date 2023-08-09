public class recursionProb1{
    public static void main(String[] args) {
        recursionProb1 main = new recursionProb1();
        var result = main.sumOfDigits(10);
        System.out.println(result);

    }

    public int sumOfDigits(int n) {
        if (n==0 || n<0) {
            return 0;
        }
        return n%10 + sumOfDigits(n/10);

    }
}