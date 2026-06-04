import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        
        long left = 1;
        long right = (long) times[times.length - 1] * n;
        long answer = right;
        
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long totalPassed = 0;
            
            for (int time : times) {
                totalPassed += mid / time;
                
                if (totalPassed >= n) {
                    break;
                }
            }
            
            if (totalPassed >= n) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return answer;
    }
}