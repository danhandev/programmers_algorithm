import java.util.PriorityQueue;

public class Solution {

    public int solution(int[] scovilleScores, int targetScoville) {
        // 최소 힙(우선순위 큐) 생성 — 가장 작은 스코빌 값이 항상 맨 위로 올라옴
        PriorityQueue<Integer> scovilleQueue = new PriorityQueue<>();

        // 초기 음식 스코빌 지수를 힙에 삽입
        for (int score : scovilleScores) {
            scovilleQueue.offer(score);
        }

        int mixCount = 0;  // 섞은 횟수

        // 힙의 최소값이 목표 스코빌보다 작을 동안 반복
        while (scovilleQueue.peek() < targetScoville) {
            // 음식이 두 개 미만이면 더 이상 섞을 수 없음
            if (scovilleQueue.size() < 2) {
                return -1;
            }

            // 가장 안 매운 음식 두 개를 꺼냄
            int leastSpicy = scovilleQueue.poll();
            int secondLeastSpicy = scovilleQueue.poll();

            // 새로 섞은 음식의 스코빌 지수 계산
            int mixedScoville = leastSpicy + (secondLeastSpicy * 2);

            // 새 음식의 스코빌 지수를 다시 힙에 넣음
            scovilleQueue.offer(mixedScoville);

            // 섞은 횟수 증가
            mixCount++;
        }

        // 모든 음식이 K 이상이 되었을 때 섞은 횟수 반환
        return mixCount;
    }
}
