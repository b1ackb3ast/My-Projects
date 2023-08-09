// I can be placed before V (5) and X (10) to make 4 and 9. 
// X can be placed before L (50) and C (100) to make 40 and 90. 
// C can be placed before D (500) and M (1000) to make 400 and 900.
// Symbol       Value
// I             1
// V             5
// X             10
// L             50
// C             100
// D             500
// M             1000

import java.util.ArrayList;
import java.util.HashMap;

public class RomanToInteger {
    public int romanToInteger(String roman) {
        int outputNum = 0;
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("I", 1);
        hm.put("V", 5);
        hm.put("X", 10);
        hm.put("L", 50);
        hm.put("C", 100);
        hm.put("D", 500);
        hm.put("M", 1000);
        hm.put("IV", 4);
        hm.put("IX", 9);
        hm.put("XL", 40);
        hm.put("XC", 90);
        hm.put("CD", 400);
        hm.put("CM", 900);
        // splitting initial string of roman numbers to
        // string array
        char[] roman1 = roman.toCharArray();
        ArrayList<String> roman2 = new ArrayList<>();
        for (int i = 0; i<roman1.length;i++) {
            roman2.add(Character.toString(roman1[i]));
        }
        // check for exceptions in string array and make new array
        ArrayList<String> array = new ArrayList<>();
        array = exceptionChecker(roman2);
        // map each key to value and add to output num 
        // variable
        for (int i = 0; i<array.size(); i++) {
            if (hm.containsKey(array.get(i))) {
                outputNum += hm.get(array.get(i));
            }
        }
        return outputNum;
    }
    // exception checker method to create new string array with exceptions
    public ArrayList<String> exceptionChecker(ArrayList<String> arr) {
        ArrayList<String> array = new ArrayList<>();
        int i = 0;
        
        while(i<arr.size()) {
            if (i< arr.size()-1) {
                if (arr.get(i).equals("I") && arr.get(i+1).equals("V") ) {
                    array.add("IV");
                    i+=2;
                } else if (arr.get(i).equals("I") && arr.get(i+1).equals("X")) {
                    array.add("IX");
                    i+=2;
                } else if (arr.get(i).equals("X") && arr.get(i+1).equals("L")) {
                    array.add("XL");
                    i+=2;
                } else if (arr.get(i).equals("X") && arr.get(i+1).equals("C")) {
                    array.add("XC");
                    i+=2;
                } else if (arr.get(i).equals("C") && arr.get(i+1).equals("D")) {
                    array.add("CD");
                    i+=2;
                } else if (arr.get(i).equals("C") && arr.get(i+1).equals("M")) {
                    array.add("CM");
                    i+=2;
                } else {
                    array.add(arr.get(i));
                    i++;
                }
            } else {
                array.add(arr.get(i));
                    i++;
            }
            
        }
        return array;
    }
}

    