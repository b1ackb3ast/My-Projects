// create a 2d array to store arrays in an array
// convert strings to arrays and add arrays to 2d array
// compare the first letter in the first array with all the first letters of the 
// other arrays
// keep doing that until there is a mismatch. for every iteration add the letter to a
// string str.
// print out str upon hitting the mismatch.




public class LongestCommonPrefix {
    public String lcm(String[] arr) {
        String[][] arr2 = new String[arr.length][];
        // converting strings to arrays and adding arrays to arr2
        for (int i=0; i<arr.length; i++) {
            arr2[i] = arr[i].split("(?!^)");
        }
        int compare = checkShort(arr2);
        String string = "";
        for (int letter = 0; letter< arr2[compare].length; letter++) {
            for(int word = 0; word< arr2.length; word++) {
                if (!(arr2[compare][letter].equals(arr2[word][letter]))) {
                    
                    return string;
                }
                
            }
            string = string + arr2[compare][letter];
            
        }
        return string;
            
    }
    // method to check for array with shortest length
    public int checkShort(String[][] arr) {
        int smallestSize = arr[0].length;
        int smallestIndex = 0;
        for (int i = 1; i<arr.length; i++) {
            if (arr[i].length<smallestSize) {
                smallestSize = arr[i].length;
                smallestIndex = i;

            }
        }
        return smallestIndex;
    }
}