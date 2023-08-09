// power function.
public class recursionProb2{
    public static void main(String[] args){
        recursionProb2 main = new recursionProb2();
        var result = main.powerFunction(3, -2);
        System.out.println(result);
    }

    public int powerFunction(int base ,int exp){
        if (exp<0)
            return -1;
        if (exp == 0)
            return 1;
        return base * powerFunction(base, exp-1);
        
    
    }
}