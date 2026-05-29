import java.util.*;

class Solution {
    public String solution(String s) {
        Map<String, Integer> enroll = new TreeMap();
        
        for (int i = 0; i < s.length(); i++) {
            enroll.put(String.valueOf(s.charAt(i)), enroll.getOrDefault(String.valueOf(s.charAt(i)), 0) + 1);
        }
                       
        StringBuilder sb = new StringBuilder();
        Set<String> keys = enroll.keySet();
        for (String key : keys) {
            if (enroll.get(key) == 1) {
                sb.append(key);
            }
        }
        
        // sb.sort();
        return sb.toString();
    }
}