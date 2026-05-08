import java.util.*;

class Solution {
    public int solution(String[] strArr) {
        Map<Integer, Integer> lengthMap = new HashMap<>();
        
        for (String s : strArr) {
            int sLength = s.length();
            
            lengthMap.put(sLength, lengthMap.getOrDefault(sLength, 0) + 1);
        }
        
        int maxGroupSize = 0;
        
        for (int count : lengthMap.values()) {
            if (count > maxGroupSize) {
                maxGroupSize = count;
            }
        }
        
        return maxGroupSize;
    }
}