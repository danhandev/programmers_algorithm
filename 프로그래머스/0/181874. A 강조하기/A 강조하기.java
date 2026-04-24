import java.util.stream.*;

class Solution {
    public String solution(String myString) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < myString.length(); i++) {
            char current = myString.charAt(i);
            
            if (current == 'a') {
                sb.append("A");
            } else if (current != 'A' && Character.isUpperCase(current)) {
                sb.append(Character.toLowerCase(current));
            } else {
                sb.append(current);
            }            
        }
        
        return sb.toString();
    }
}