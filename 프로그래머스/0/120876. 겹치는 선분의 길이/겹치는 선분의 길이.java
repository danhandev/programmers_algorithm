import java.util.*;

class Solution {
    public int solution(int[][] lines) {
//         Arrays.sort(lines, (a, b) -> {
//             if (a[0] == b[0]) return a[1] - b[1];
//             return a[0] - b[0];
//         });
        
        int start = lines[0][0];
        int end = lines[0][1];
        for(int[] line : lines) {
            if (line[1] > end) end = line[1];
            if (line[0] < start) start = line[0];
        }
        
        int count = 0;
        for (int i = start; i <= end; i++) {
            int contain = 0;
            if (i >= lines[0][0] && i + 1 <= lines[0][1]) contain++;
            if (i >= lines[1][0] && i + 1 <= lines[1][1]) contain++;
            if (i >= lines[2][0] && i + 1  <= lines[2][1]) contain++;
            if (contain >= 2) count++;
        }
        return count;
    }
}