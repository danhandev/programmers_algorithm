import java.util.*;

class Solution {
    public int[] solution(String my_string) {
        my_string = my_string.replaceAll("[a-z]", "");
        
        int[] numArray = new int[my_string.length()];
        
        for (int i = 0; i < numArray.length; i++) {
            char num = my_string.charAt(i);
            
            if (num >= '0' && num <= '9') {
                numArray[i] = num - '0';
            }
        }
        
        Arrays.sort(numArray);
        
        return numArray;
    }
}