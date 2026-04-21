import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int startIndex = -1;
        int endIndex = -1;
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 2) {
                if (startIndex == -1) {
                    startIndex = i;
                }
                
                endIndex = i;
            }
        }
        
        
        if (startIndex == -1) {
            return new int[]{-1};
        }
                
        return Arrays.copyOfRange(arr, startIndex, endIndex + 1);
    }
}