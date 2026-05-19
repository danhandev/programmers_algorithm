import java.util.*;

class Solution {
    public int solution(int[] array) {
        int maxCount = 0;
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int number : array) {
            // 1. 실시간으로 빈도수를 계산합니다.
            int count = map.getOrDefault(number, 0) + 1;
            map.put(number, count); // 맵에 먼저 업데이트를 반영합니다.
            
            // 2. 단독 1등이 나타난 경우
            if (count > maxCount) {
                maxCount = count;
                answer = number;
            } 
            // 3. 공동 1등(최빈값 중복)이 발생한 경우
            else if (count == maxCount) {
                answer = -1;
            }
        }
        
        return answer;
    }
}