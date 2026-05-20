class Solution {
    public int solution(int n) {
        for (int p = 1; p <= n * 6; p++) {
            if (p % n == 0 && p % 6 == 0) {
                return p / 6;
            }
        }
        
        return -1;
    }
}