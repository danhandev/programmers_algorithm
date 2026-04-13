class Solution {
    public int solution(String ineq, String eq, int n, int m) {
        boolean result;

        // 1. 각 문자열 조합에 따라 비교 연산을 수행합니다.
        if (ineq.equals(">")) {
            if (eq.equals("=")) {
                result = (n >= m); // ">"와 "=" 조합
            } else {
                result = (n > m);  // ">"와 "!" 조합
            }
        } else { // ineq가 "<"인 경우
            if (eq.equals("=")) {
                result = (n <= m); // "<"와 "=" 조합
            } else {
                result = (n < m);  // "<"와 "!" 조합
            }
        }

        // 2. 결과가 참이면 1, 거짓이면 0을 반환합니다.
        return result ? 1 : 0;
    }
}