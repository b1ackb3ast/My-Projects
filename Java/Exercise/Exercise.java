public class Exercise {
    
    static void missingNumber(int[] intArray) {
        int number = 1;
        for (int i=0; i<intArray.length; i++) {
            if (number == intArray[i]) {
                number++;                   
                i = 0;
                }
            if (i == (intArray.length -1) & number != intArray[i]) {
                System.out.println("The missing number is " + number + ".");
                return;
            }
            
        }
        
    }

    public static void main(String[] args) {
        int[] trialArray = new int[] {1, 3, 4, 6, 2};
        missingNumber(trialArray);  
      
      
      
    }
}
