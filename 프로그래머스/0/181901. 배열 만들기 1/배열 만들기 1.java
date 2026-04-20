import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int n, int k) {
        List<Integer> result = new ArrayList<>();
        
        for (int num = k; num <= n; num += k) {
            result.add(num);
        }
        
        return result.stream().mapToInt(i -> i).toArray();
    }
}