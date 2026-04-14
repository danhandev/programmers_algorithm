class Solution {
    public int solution(int n, String control) {
        
        for (int i = 0; i < control.length(); i++) {
            char current = control.charAt(i);
            
            if (current == 'w') {
                n += 1;
                continue;
            }
            if (current == 's') {
                n -= 1;
                continue;
            }
            if (current == 'd') {
                n += 10;
                continue;
            }
            if (current == 'a') {
                n -= 10;
            }
        }
        return n;
    }
}