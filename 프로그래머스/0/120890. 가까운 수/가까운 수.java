import java.util.*;

class Solution {
    public int solution(int[] array, int n) {
        Arrays.sort(array);
        int targetIndex = -1;
        
        if (n < array[0]) {
            return array[0];
        }
        
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= n) {
                targetIndex = i;
                break;
            }
        }
        
        if (targetIndex == -1) {
            return array[array.length - 1];
        }
        
        return ((n - array[targetIndex - 1]) <= (array[targetIndex] - n)) ? array[targetIndex - 1] : array[targetIndex];
    }
}