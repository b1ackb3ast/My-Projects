public class recursiveFunctionFactorial {
    public static void main(String[] args) {
    recursiveFunctionFactorial recursion = new recursiveFunctionFactorial();
      var rec = recursion.factorial(3);
      System.out.println(rec);
    }
    public int factorial(int n){
        if (n < 1){
            return -1;
        }
        if (n==0 || n ==1) {
                return 1;
            }
        
        return n * factorial(n -1);
    }


}