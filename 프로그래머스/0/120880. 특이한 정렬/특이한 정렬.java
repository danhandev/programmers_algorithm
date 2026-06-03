import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] numlist, int n) {
        Integer[] array = Arrays.stream(numlist).boxed().toArray(Integer[]::new);
        
        Arrays.sort(array, (a, b) -> {
            if (Math.abs(a - n) == Math.abs(b - n)) return b - a;
            return Math.abs(a - n) - Math.abs(b - n);
        });
        return Arrays.stream(array).mapToInt(i -> i).toArray();
    }
}