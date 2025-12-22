import java.util.Map;
import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> types = new HashMap<>();
        
        for (String[] cloth : clothes) {
            String type = cloth[1];
            types.put(type, types.getOrDefault(type, 0) + 1);
        }
        
        int conbination = 1;

        for (int count : types.values()) {
            conbination *= (count + 1);
        }
        
        return conbination - 1; 
    }
}