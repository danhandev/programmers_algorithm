// 최대한 많은 종류의 폰켓몬을 포함해서 N/2마리를 선택
// 중복 제거 k < N/2: k, k >= N/2: N/2
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(int[] nums) {
        Map<Integer, Integer> poketmon_hash = new HashMap<>();
        int answer = nums.length / 2; // 최대 고를 수 있는 폰켓몬 종류의 수
            
        for (int num: nums) {
            poketmon_hash.put(num, poketmon_hash.getOrDefault(num, 0) + 1);
        }
        
        int numberOfKeys = poketmon_hash.size();
        
        if (numberOfKeys < answer) {
            return numberOfKeys;
        } else {
            return answer;
        }
    }
}