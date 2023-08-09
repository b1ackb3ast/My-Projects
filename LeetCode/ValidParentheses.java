// create a stack and loop through the elements in the arraylist strArr. then if an element
// is a open bracket it is added to the stack and this repeats until a closed bracket is
// reached. when the closed bracket is reached pop an element from the stack and compare if
// it is a pair. if it is and the next element is a closed bracket pop the next element and repeat
// until the stack is empty
// for loop through all the elements and if it exits return true, else false.

// helper method, can use hashmap to check for pairs and then remove then from the string
// if all the elements can be removed, then true, else false.
import java.util.HashMap;
import java.util.Stack;



import java.util.ArrayList;

public class ValidParentheses {
    public boolean isValid(String s) {
        String[] arr = s.split("(?!^)");
        ArrayList<String> strArr = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        HashMap<String, String> hm = new HashMap<>();
        HashMap<String, String> hm1 = new HashMap<>();
        hm.put("(", ")");
        hm.put("[", "]");
        hm.put("{", "}");
        hm1.put(")", "(");
        hm1.put("}", "{");
        hm1.put("]", "[");
        String compare;
        for (int i = 0; i<arr.length;i++) {
            strArr.add(arr[i]);
        }

        boolean result = helper(strArr);
        if (result == false) {
            return false;
        }
        for(int i = 0; i<strArr.size();i++) {
            
            // if element is an open bracket
            if (hm.containsKey(strArr.get(i))) {
                stack.add(strArr.get(i));
            } 
            // if element is a close bracket
            else {
                if (stack.isEmpty()) {
                    return false;
                }
                // if first element is a close bracket
                else if (i == 0 && hm.containsValue(strArr.get(i))) {
                    return false;
                }
                else {
                    compare = stack.pop();
                    if (!(hm.get(compare).equals(strArr.get(i))))
                        return false;

                }
            }
        }
        return true;
    }
    public boolean helper(ArrayList<String> strArr) {
        int value1 = 0;
        int value2 = 0;
        int value3 = 0;
        int value4 = 0;
        int value5 = 0;
        int value6 = 0;

        for (int i = 0; i<strArr.size(); i++) {
            if (strArr.get(i).equals("(")) {
                value1++;
            }
            else if (strArr.get(i).equals(")")) {
                 value2++;
            }
            else if (strArr.get(i).equals("{")) {
                value3++;
            }
            else if (strArr.get(i).equals("}")) {
                value4++;
            }
            else if (strArr.get(i).equals("[")) {
                value5++;
            }
            else if (strArr.get(i).equals("]")) {
                value6++;
            }
        }
        if (value1 != value2 || value3 != value4 || value5 != value6) {
            return false;
        }
        else {
            return true;
        }

    } 
}
