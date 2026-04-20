import java.util.*;

class Solution {
    public int[] solution(int start_num, int end_num) {
        int[] result = new int[start_num - end_num + 1];
        int idx = 0;
        
        for (int n = start_num; n >= end_num; n--) {
            result[idx++] = n;
        }
        
        return result;
    }
}