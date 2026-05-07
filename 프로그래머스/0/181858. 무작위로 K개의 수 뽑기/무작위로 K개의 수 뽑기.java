import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] arr, int k) {
        Set<Integer> usedNumber = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < arr.length; i++) {
            int current = arr[i];
            
            if (!usedNumber.contains(current)) {
                usedNumber.add(current);
                result.add(current);
            }
            
            if (result.size() == k) {
                break;
            }
        }
               
        int resultLength = result.size();
        for (int i = 0; i < k - resultLength; i++) {
            result.add(-1);
        }
                
        return result.stream().mapToInt(i -> i).toArray();
    }
}