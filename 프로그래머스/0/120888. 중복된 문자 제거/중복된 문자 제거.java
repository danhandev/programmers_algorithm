import java.util.*;

class Solution {
    public String solution(String my_string) {
        Set<String> uniqueString = new LinkedHashSet();
        
        for (int i = 0; i < my_string.length(); i++) {
            uniqueString.add(String.valueOf(my_string.charAt(i)));
        }
        
        StringBuilder sb = new StringBuilder();
        for (String s :  uniqueString) {
            sb.append(s);
        }
        
        return sb.toString();
    }
}