import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String myString) {
        String[] splitString = myString.split("x");
        int splitStringLength = splitString.length;
        
        List<Integer> lengthArray = new ArrayList<>();
        
        // if (myString.charAt(0) == 'x') {
        //     lengthArray.add(0);
        // }
        
        for (String s : splitString) {
            lengthArray.add(s.length());
        }
                
        if (myString.charAt(myString.length() - 1) == 'x') {
            lengthArray.add(0);
        }
        
        
        return lengthArray.stream().mapToInt(i -> i).toArray();
    }
}