// 최대한 많은 종류의 폰켓몬을 포함해서 N/2마리를 선택
// 핵심 중복 제거: k < N/2: k, k >= N/2: N/2
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> types = new HashSet<>();
        
        for (int num : nums) {
            types.add(num);
        }
        
        int maxSelectable = nums.length / 2;
        
        return Math.min(types.size(), maxSelectable);
    }
}