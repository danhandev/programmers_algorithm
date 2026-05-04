import java.util.*;
import java.util.stream.*;

class Solution {
    public String[] solution(String myString) {
        String[] splitString = myString.split("x");
        List<String> filterString = new ArrayList<>();
        
        for (int i = 0; i < splitString.length; i++) {
            if (!"".equals(splitString[i])) {
                filterString.add(splitString[i]);
            }
        }
        
        String[] answer = filterString.toArray(new String[0]);
        Arrays.sort(answer);
        
        
        return answer;
    }
}