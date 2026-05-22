
import java.util.*;

class Solution {
    public String solution(int age) {
        List<Integer> digitList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        
        while (age >= 1) {
            digitList.add(age % 10);
            age /= 10;
        }
        
        for (int i = digitList.size() - 1; i >= 0; i--) {
            char c = (char) (digitList.get(i) + 'a');
            sb.append(String.valueOf(c));
        }
        
        return sb.toString();
    }
}