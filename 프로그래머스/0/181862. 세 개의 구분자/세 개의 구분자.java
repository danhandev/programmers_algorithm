import java.util.*;
import java.util.stream.*;

class Solution {
    public String[] solution(String myStr) {
        int startIndex = 0;
        int endIndex = 0;
        List<String> splitArray = new ArrayList<>();
        
        for (int i = 0; i < myStr.length(); i++) {
            if (myStr.charAt(i) == 'a' || myStr.charAt(i) == 'b' || myStr.charAt(i) == 'c') {
                if (startIndex != endIndex) {
                    splitArray.add(myStr.substring(startIndex, endIndex));
                }
                startIndex = i + 1;
                endIndex = i + 1;
            } else {
                endIndex++;
            }
        }
        
        if (startIndex != myStr.length()) {
            splitArray.add(myStr.substring(startIndex, endIndex));
        }
        
        if (splitArray.isEmpty()) {
            splitArray.add("EMPTY");
        }
        
        return splitArray.toArray(new String[0]);
    }
}