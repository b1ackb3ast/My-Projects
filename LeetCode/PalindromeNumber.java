public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        // convert the integer to string
        String strx = Integer.toString(x);
        // create char array for string from left to right
        char[] ch1 = new char[strx.length()];
        for (int i = 0; i<strx.length(); i++) {
            ch1[i] = strx.charAt(i);
        }
        // create char array for string from right to left
        char[] ch2 = new char[strx.length()];
        int k = 0;
        for (int i = strx.length()-1; i>=0; i--) {
            ch2[k] = strx.charAt(i);
            k++;
        }
        for (int i = 0; i<strx.length(); i++) {
            if(ch1[i]!=ch2[i]) {
                return false;
            }
        }
        return true;
    }
}
