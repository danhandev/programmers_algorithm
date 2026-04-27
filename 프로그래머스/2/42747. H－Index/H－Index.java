import java.util.*;

// 2 4 5 6 8 9
// 6 5 4 3 2 1

class Solution {
    public int solution(int[] citations) {
        int n = citations.length;
        
        Arrays.sort(citations);
        
        for (int i = 0; i < n; i++) {
            if (n - i <= citations[i]) {
                return n - i;
            }
        }
        
        return 0;
    }
}