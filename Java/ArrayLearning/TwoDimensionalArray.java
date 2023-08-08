import java.util.Arrays;
public class TwoDimensionalArray {
    int arr[][] = null;
    //Constructor
    public TwoDimensionalArray(int numberOfRows, int numberOfColumns){
        this.arr = new int[numberOfRows][numberOfColumns];
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr.length; col++) {
                arr[row][col] = Integer.MIN_VALUE;
            }
        }
    }
    //Inserting value in the Array
    public void insertValueInTheArray(int row, int col, int value) {
        try {
          if (arr[row][col] == Integer.MIN_VALUE) {
            arr[row][col] = value; 
            System.out.println("The value is successfully inserted.");
          } 
          else {
              System.out.println("This cell is already occupied.");
          } 
        } 
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index for 2D array.");
        }
    }
    

    //Accessing cell value from given array
    public void accessCell(int row, int col) {
        System.out.println("\nAccessing Row#" + row + ", Col#" + col);
        try {
            System.out.println(" Cell value is: " + arr[row][col]);

        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index for 2D array.");
        }
    }

    // Traversal of 2D array

    public void traverse2DArray() {
     
    }
    // Searching a single value from the Array and deleting it
    public void searchingValue(int value) {
        for  (int row = 0;row<arr.length; row++) {
            for (int col = 0; col<arr[0].length; col++) {
                if (arr[row][col] == value) {
                    System.out.println("Value is found at \nRow: " + row + "\nCol: " + col);
                    arr[row][col] = Integer.MIN_VALUE;
                    System.out.println(Arrays.deepToString(arr));
                    return;
                    
                } 
            }
        }
    System.out.println("Value is not found");
    }   
    // Deleting a value from Array
    public void deleteValueFromArray(int row, int col) {
        try {
            System.out.println("Successfully deleted " + arr[row][col]);
            arr[row][col] = Integer.MIN_VALUE;
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("This index os not valid for the array.");
        }
    }



}



// import java.util.Arrays;
// class Main {
   // public static void main(String[] args) {
       // TwoDimensionalArray sda = new TwoDimensionalArray(3, 3);
       // sda.insertValueInTheArray(0,0, 10);
       // System.out.println(Arrays.deepToString(sda.arr));

   //} 
//}