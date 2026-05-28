import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int count = 0; // 섞은 횟수
        
        for (int s : scoville) {
            pq.offer(s);
        }
        
        while(pq.peek() < K) {
            if (pq.size() == 1 && pq.peek() < K) {
                return -1;
            }
            int min = pq.poll();
            int secondMin = pq.poll();
            
            pq.offer(min + secondMin * 2);
            
            count++;
        }
        
        
        return count;
    }
}