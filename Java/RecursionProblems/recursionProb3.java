// how to find the greatest common divisor of two numbers
public class recursionProb3{
    public static void main(String[] args) {
        recursionProb3 main = new recursionProb3();
        var result = main.gcd(12, 8);
        System.out.println(result);

    }
    public int gcd(int a, int b){
        if (a < 0 || b < 0)
            return -1;
        if (b == 0){
            return a;
        }
        return gcd(b, a%b);
    }
}
