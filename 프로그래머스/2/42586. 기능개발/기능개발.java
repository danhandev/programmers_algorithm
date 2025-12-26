import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> remain_days = new LinkedList<>();
        
        // 남은 일수 계산 후 queue에 추가
        for (int i = 0; i < progresses.length; i++) {
            int remain_day = (100 - progresses[i] + speeds[i] - 1) / speeds[i];
            remain_days.offer(remain_day);
        }
        
        // 각 배포마다 기능 수 저장
        List<Integer> result = new ArrayList<>();
        
        // queue에서 하나씩 꺼내기
        while (!remain_days.isEmpty()) {
            int current = remain_days.poll();
            int count = 1;
            
            while (!remain_days.isEmpty() && remain_days.peek() <= current) {
                remain_days.poll();
                count++;
            }
            result.add(count);
        }
        
        // List -> int[]
        int[] answer = new int[result.size()];
        
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}