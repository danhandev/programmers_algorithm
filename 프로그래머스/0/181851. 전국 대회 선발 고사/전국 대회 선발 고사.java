import java.util.*;

class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < attendance.length; i++) {
            if (attendance[i]) {
                list.add(i);
            }
        }
        
        Collections.sort(list, (a, b) -> rank[a] - rank[b]);
        
        int a = list.get(0);
        int b = list.get(1);
        int c = list.get(2);
        
        return 10000 * a + 100 * b + c;
    }
}