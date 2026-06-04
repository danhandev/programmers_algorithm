class Solution {
    public int solution(String A, String B) {
        int len = A.length();
        
        for (int i = 0; i < len; i++) {
            String move = A.substring(len - i, len) + A.substring(0, len - i);
            
            if (B.equals(move)) {
                return i;
            }
        }
        
        return -1;
    }
}