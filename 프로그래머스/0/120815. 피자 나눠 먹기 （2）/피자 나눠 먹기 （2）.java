class Solution {
    public int solution(int n) {
        return n / getGCD(n, 6);
    }
    
    private int getGCD(int a, int b) {
        if (b == 0) return a;
        return getGCD(b, a % b);
    }
}