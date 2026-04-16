import java.util.*;

class Solution {
    public int[] solution(int start_num, int end_num) {
        List<Integer> result = new ArrayList<>();
        
        for (int n = start_num; n <= end_num; n++) {
            result.add(n);
        }
        
        return result.stream().mapToInt(n -> n).toArray();
    }
}