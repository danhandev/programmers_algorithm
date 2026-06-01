import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String my_string) {
        char[] lowerList = new char[my_string.length()];
        
        for (int i = 0; i < my_string.length(); i++) {
            char c = my_string.charAt(i);
            
            if (Character.isUpperCase(c)) {
                lowerList[i] = Character.toLowerCase(c);
            } else {
                lowerList[i] = c;
            }
        }
        
        Arrays.sort(lowerList);
        
        StringBuilder sb = new StringBuilder();
        
        for (char c : lowerList) {
            sb.append(c);
        }
        return sb.toString();
    }
}