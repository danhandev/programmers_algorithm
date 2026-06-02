import java.util.*;

class Solution {
    public int solution(String[] spell, String[] dic) {
        for (String word : dic) {
            List<String> list = new ArrayList<>();
            for (String s : spell) {
                list.add(s);
            }
            
            for (int i = 0; i < word.length(); i++) {
                String s = String.valueOf(word.charAt(i));
                if (list.contains(s)) {
                    list.remove(s);
                }
            }
                    
            if (list.isEmpty()) {
                return 1;
            }
            
        }
        return 2;
    }
}