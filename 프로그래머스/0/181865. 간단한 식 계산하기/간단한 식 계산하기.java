class Solution {
    public long solution(String binomial) {
        // 1. 공백을 기준으로 문자열을 자릅니다.
        // parts[0]은 a, parts[1]은 op, parts[2]는 b가 됩니다.
        String[] parts = binomial.split(" ");
        
        // 2. 숫자로 변환합니다. 
        // 결과값이 클 수 있으므로 계산 시 long 타입을 고려하는 것도 좋은 습관입니다.
        long a = Long.parseLong(parts[0]);
        long b = Long.parseLong(parts[2]);
        String op = parts[1];
        
        // 3. 연산자에 따라 계산 결과를 반환합니다.
        if (op.equals("+")) {
            return a + b;
        } else if (op.equals("-")) {
            return a - b;
        } else { // "*" 인 경우
            return a * b;
        }
    }
}