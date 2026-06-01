class Solution {
    public int solution(int n, int t) {
        int power = n;
        for (int i = 0; i < t; i++) {
            power *= 2;
        }
        return power;
    }
}