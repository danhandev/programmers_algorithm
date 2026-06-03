import java.util.*;

class Solution {
    public int solution(int[][] dots) {
        Arrays.sort(dots, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });
        
        int dot1dot2 = Math.abs(10000 * (dots[0][0] - dots[1][0]) / (dots[0][1] - dots[1][1]));
        int dot3dot4 = Math.abs(10000 * (dots[2][0] - dots[3][0]) / (dots[2][1] - dots[3][1]));
        
        return (dot1dot2 == dot3dot4) ? 1 : 0;
    }
}