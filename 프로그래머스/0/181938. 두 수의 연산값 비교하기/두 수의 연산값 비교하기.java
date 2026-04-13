class Solution {
    public int solution(int a, int b) {
        Integer ab = Integer.parseInt("" + a + b);
        return Math.max(ab, 2 * a * b);
    }
}