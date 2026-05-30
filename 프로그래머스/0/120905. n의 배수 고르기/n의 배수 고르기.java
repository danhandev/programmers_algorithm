import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int n, int[] numlist) {
        List<Integer> nMultiple = new ArrayList<>();
        for (int num : numlist) {
            if (num % n == 0) {
                nMultiple.add(num);
            }
        }
        
        return nMultiple.stream().mapToInt(i -> i).toArray();
    }
}