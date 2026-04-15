import java.util.*;

class Solution {
    public int[] solution(int l, int r) {
        List<Integer> list = new ArrayList<>();
        
        
        for (int n = l; n <= r; n++) {
            String current = String.valueOf(n);
            boolean flag = true;
            
            for (int i = 0; i < current.length(); i++) {
                char c = current.charAt(i);
                
                if (c != '5' && c != '0') {
                    flag = false;
                    break;
                }
            }
            
            if (flag) {
                list.add(n);
            }
        }
        
        if (list.isEmpty()) {
            list.add(-1);
        }
        
        return list.stream().mapToInt(i -> i).toArray();
    }
}