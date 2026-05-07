import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int n = arr.length;
        
        int targetLength = 1;
        
        while (targetLength < n) {
            targetLength *= 2;
        }

        return Arrays.copyOf(arr, targetLength);
    }
}