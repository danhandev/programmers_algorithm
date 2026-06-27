import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        int sum = 0;
        boolean[] exists = new boolean[10];
        
        for (int i = 0; i < numbers.length; i++) {
            exists[numbers[i]] = true;
        }
        
        for (int i = 0; i < exists.length; i++) {
            if (!exists[i]) sum += i;
        }
        return sum;
    }
}