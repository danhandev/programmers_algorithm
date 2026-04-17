import java.util.*;

class Solution {
    public int solution(int a, int b, int c, int d) {
        int[] dice = {a, b, c, d};
        Arrays.sort(dice); // 오름차순 정렬

        // 1. 네 숫자가 모두 같음
        if (dice[0] == dice[3]) {
            return 1111 * dice[0];
        }
        
        // 2. 세 숫자가 같음 (p, p, p, q) 또는 (q, p, p, p)
        if (dice[0] == dice[2] || dice[1] == dice[3]) {
            int p = (dice[0] == dice[2]) ? dice[0] : dice[3];
            int q = (dice[0] == dice[2]) ? dice[3] : dice[0];
            return (int) Math.pow(10 * p + q, 2);
        }
        
        // 3. 두 개씩 같음 (p, p, q, q)
        if (dice[0] == dice[1] && dice[2] == dice[3]) {
            return (dice[0] + dice[2]) * Math.abs(dice[0] - dice[2]);
        }
        
        // 4. 두 개만 같고 나머지 다름 (p, p, q, r) 또는 (q, p, p, r) 또는 (q, r, p, p)
        if (dice[0] == dice[1] || dice[1] == dice[2] || dice[2] == dice[3]) {
            if (dice[0] == dice[1]) return dice[2] * dice[3];
            if (dice[1] == dice[2]) return dice[0] * dice[3];
            return dice[0] * dice[1];
        }
        
        // 5. 모두 다름
        return dice[0];
    }
}