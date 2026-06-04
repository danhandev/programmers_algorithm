import java.util.*;

class Solution {
    public int solution(String before, String after) {
        char[] b = new char[before.length()];
        char[] a = new char[after.length()];
        
        for (int i = 0; i < a.length; i++) {
            b[i] = before.charAt(i);
            a[i] = after.charAt(i);
        }
        
        Arrays.sort(b);
        Arrays.sort(a);
        
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) return 0;
        }
        
        return 1;
    }
}