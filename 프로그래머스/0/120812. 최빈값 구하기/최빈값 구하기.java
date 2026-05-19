import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(int[] array) {
        // 1. 숫자의 등장 빈도를 저장할 Map을 생성합니다. (Key: 숫자, Value: 등장 횟수)
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        
        // 2. 배열을 순회하며 각 숫자의 빈도수를 누적합니다.
        // 이전에 배웠던 getOrDefault를 활용하여 깔끔하게 처리합니다.
        for (int num : array) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        int maxFrequency = 0; // 가장 높은 빈도수
        int mode = -1;        // 최빈값 (기본값 -1)
        boolean isDuplicate = false; // 최빈값이 중복되는지 여부
        
        // 3. 빈도수 맵을 순회하며 최빈값을 찾습니다.
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int num = entry.getKey();
            int frequency = entry.getValue();
            
            // 현재 숫자의 빈도수가 기존 최댓값보다 크다면 새로운 최빈값으로 갱신합니다.
            if (frequency > maxFrequency) {
                maxFrequency = frequency;
                mode = num;
                isDuplicate = false; // 새로운 최댓값이 나왔으므로 중복 상태를 해제합니다.
            } 
            // 현재 숫자의 빈도수가 기존 최댓값과 같다면 중복된 최빈값입니다.
            else if (frequency == maxFrequency) {
                isDuplicate = true;
            }
        }
        
        // 4. 최빈값이 여러 개면 -1을, 하나뿐이면 해당 최빈값을 반환합니다.
        return isDuplicate ? -1 : mode;
    }
}