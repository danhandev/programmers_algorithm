import java.util.Stack;

class Solution {
    boolean solution(String s) {
        // Character 타입을 담는 정석적인 스택 선언
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            
            if (current == '(') {
                stack.push(current); // 열린 괄호는 무조건 스택에 저장
            } else {
                // 핵심 예외 처리: ')'를 만났는데 꺼낼 '('가 없다면 올바르지 않은 괄호
                if (stack.isEmpty()) {
                    return false; 
                }
                stack.pop(); // 짝이 맞으므로 스택에서 제거
            }
        }
        
        // 최종 판단: 문자열을 다 돌았을 때 스택이 깨끗하게 비어있어야 true
        return stack.isEmpty();
    }
}