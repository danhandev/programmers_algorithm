import java.util.stream.*;
import java.util.*;

class Solution {
    public String[] solution(String my_string) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        
        for (char c : my_string.toCharArray()) {
            if (c != ' ') {
                sb.append(c);
            } else {
                if (sb.length() > 0) {
                    result.add(sb.toString());
                    sb.setLength(0);
                }
            }
        }
        
        if (sb.length() > 0) {
            result.add(sb.toString());
        }
        
        return result.toArray(String[]::new);
    }
}