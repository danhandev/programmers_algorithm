import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        List<Integer> result = new ArrayList<>();
        
        for (String intStr : intStrs) {
            String newStr = intStr.substring(s,s+l);
            int newInt = Integer.parseInt(newStr);
                
            if (newInt > k) {
                result.add(newInt);
            }
        }
        
        return result.stream().mapToInt(i -> i).toArray();
    }
}