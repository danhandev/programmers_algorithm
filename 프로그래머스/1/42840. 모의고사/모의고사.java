import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] answers) {
        int first_count = 0;
        int second_count = 0;
        int third_count = 0;
        int[] second_rule = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        int[] third_rule = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        for (int i = 0; i < answers.length; i++) {
            int answer = answers[i];
            
            if ((i % 5) + 1 == answer) first_count++;
            if (second_rule[(i) % 8] == answer) second_count++;
            if (third_rule[(i) % 10] == answer) third_count++;
        }

        List<Integer> result = new ArrayList<>();
        int maxCount = Math.max(first_count, Math.max(second_count, third_count));
        if (first_count == maxCount) result.add(1);
        if (second_count == maxCount) result.add(2);
        if (third_count == maxCount) result.add(3);
        
        return result.stream().mapToInt(i -> i).toArray();
    }
}