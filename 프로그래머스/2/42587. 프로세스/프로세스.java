import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[]> queue = new LinkedList<>(); 
        // queue 원소: [우선순위, 원래 인덱스]

        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new int[]{priorities[i], i});
        }

        int executionOrder = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int priority = current[0];
            int index = current[1];

            // 큐에 현재 priority보다 높은 priority가 존재하는지 확인
            boolean hasHigherPriority = false;
            for (int[] q : queue) {
                if (q[0] > priority) {
                    hasHigherPriority = true;
                    break;
                }
            }

            if (hasHigherPriority) {
                // 뒤로 보냄
                queue.offer(current);
            } else {
                // 실행
                executionOrder++;
                if (index == location) {
                    return executionOrder;
                }
            }
        }

        return executionOrder;
    }
}
