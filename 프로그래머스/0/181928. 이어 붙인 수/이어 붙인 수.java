import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] num_list) {
        String oddStr = Arrays.stream(num_list)
            .filter(n -> n % 2 == 1)
            .mapToObj(String::valueOf)
            .collect(Collectors.joining());
        
        String evenStr = Arrays.stream(num_list)
            .filter(n -> n % 2 == 0)
            .mapToObj(String::valueOf)
            .collect(Collectors.joining());
        
        return Integer.parseInt(oddStr) + Integer.parseInt(evenStr);
    }
}