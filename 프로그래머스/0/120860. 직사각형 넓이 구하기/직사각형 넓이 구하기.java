import java.util.*;

class Solution {
    public int solution(int[][] dots) {
        Arrays.sort(dots, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });
        
        return Math.abs((dots[0][1] - dots[1][1]) * (dots[0][0] - dots[2][0]));
    }
}