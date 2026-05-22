import java.util.*;

class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> types = new HashSet<>();
        int nDiv2 = nums.length / 2;
        
        for (int num : nums) {
            types.add(num);
        }
        
        int typeCount = types.size();
        
        return (typeCount > nDiv2) ? nDiv2 : typeCount;
    }
}