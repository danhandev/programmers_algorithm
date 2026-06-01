import java.util.*;
import java.util.stream.*;

class Solution {
    public List<String> solution(String my_str, int n) {
        
        List<String> result = new ArrayList<>();
        int startIndex = 0;
        
        while (startIndex < my_str.length()) {
            result.add(my_str.substring(startIndex, startIndex + n));
            startIndex += n;
            
            if (startIndex >= my_str.length() - n + 1 && startIndex < my_str.length()) {
                result.add(my_str.substring(startIndex, my_str.length()));
                break;
            }
        }
        
        return result;
    }
}