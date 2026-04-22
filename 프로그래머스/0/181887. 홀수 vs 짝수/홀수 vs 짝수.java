import java.util.*;

class Solution {
    public int solution(int[] num_list) {
        int odd_sum = 0;
        int even_sum = 0;
        
        for (int i = 0; i < num_list.length; i++) {
            if (i % 2 == 0) {
                even_sum += num_list[i];
            } else {
                odd_sum += num_list[i];
            }
        }
        
        return Math.max(odd_sum, even_sum);
    }
}