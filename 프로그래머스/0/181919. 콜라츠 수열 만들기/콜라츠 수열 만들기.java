import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int n) {
        
        int current = n;
        List<Integer> result = new ArrayList<>();
        
        result.add(n);
    
        while (current != 1) {
            if (current % 2 == 0) {
                current = current / 2;
            } else {
                current = 3 * current + 1;
            }
            
            result.add(current);
        }
        
        return result.stream().mapToInt(i -> i).toArray();
    
    }
}