import java.util.Set;
import java.util.HashSet;

// 모든 번호를 HashSet에 넣고
// 각 번호의 모든 접두어를 만들어 set에 존재하는지 확인
// O(n * L)

class Solution {
    public boolean solution(String[] phone_book) {
        Set<String> set = new HashSet<>();
        
        for (String phone : phone_book) {
            set.add(phone);
        }
        
        for (String phone : phone_book) {
            for (int i = 1; i < phone.length(); i++) {
                if (set.contains(phone.substring(0, i))) {
                    return false;
                }
            }
        }
        
        return true;
    }
}