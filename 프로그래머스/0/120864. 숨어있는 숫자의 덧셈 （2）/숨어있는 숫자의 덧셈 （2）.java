import java.util.*;

class Solution {
    public int solution(String my_string) {
        int sum = 0;
        String[] list = my_string.split("[a-zA-Z]+");
        Arrays.stream(list).forEach(i -> System.out.println(i));
        for (String s : list) {
            if (!s.isEmpty()) {
                sum += Integer.parseInt(s);
            }
        }
        
        return sum;
    }
}