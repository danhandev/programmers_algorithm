class Solution {
    public String solution(String a, String b) {
        // 결과를 담을 가변 문자열 객체
        StringBuilder answer = new StringBuilder();
        
        // 1. 각 숫자의 맨 뒤(일의 자리) 인덱스부터 시작합니다.
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0; // 올림수 보관함
        
        // 2. 숫자가 남아있거나 더해야 할 올림수가 있다면 계속 반복합니다.
        while (i >= 0 || j >= 0 || carry > 0) {
            
            // 3. 현재 자릿수의 숫자를 가져옵니다. (더 이상 없으면 0으로 처리)
            int num1 = (i >= 0) ? a.charAt(i--) - '0' : 0;
            int num2 = (j >= 0) ? b.charAt(j--) - '0' : 0;
            
            // 4. 두 숫자와 이전 자리에서 올라온 올림수를 더합니다.
            int sum = num1 + num2 + carry;
            
            // 5. 10이 넘으면 다음 자리를 위해 carry를 1로, 아니면 0으로 만듭니다.
            carry = sum / 10;
            
            // 6. 10으로 나눈 나머지가 현재 자릿수의 진짜 숫자가 됩니다.
            answer.append(sum % 10);
        }
        
        // 7. 일의 자리부터 거꾸로 추가했으므로 뒤집어서 반환합니다.
        return answer.reverse().toString();
    }
}