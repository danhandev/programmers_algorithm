import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Deque<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < priorities.length; i++) {
            q.offer(new int[]{priorities[i], i});
        }
        
        int execute_count = 0;
        while (true) {
            int[] current = q.poll();
            boolean hasHigher = false;
            for (int[] other : q) {
                if (other[0] > current[0]) {
                    hasHigher = true;
                    break;
                }
            }
            
            if (hasHigher) {
                q.offer(current);
            } else {
                execute_count++; 
                if (current[1] == location) {
                    return execute_count;
                }
            }
        }
    }
}