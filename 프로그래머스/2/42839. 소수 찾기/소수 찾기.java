import java.util.*;

class Solution {
    // 중복 제거를 위해 HashSet 사용
    Set<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        // 1. 모든 순열 만들기
        boolean[] visited = new boolean[numbers.length()];
        makePermutations(numbers, "", visited);
        
        // 2. 소수 개수 세기
        int count = 0;
        for (int num : set) {
            if (isPrime(num)) {
                count++;
            }
        }
        
        return count;
    }
    
    // 재귀를 이용한 순열 생성 (DFS)
    private void makePermutations(String numbers, String current, boolean[] visited) {
        if (!current.equals("")) {
            set.add(Integer.parseInt(current));
        }
        
        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                makePermutations(numbers, current + numbers.charAt(i), visited);
                visited[i] = false; // 백트래킹: 돌아올 때 방문 표시 해제
            }
        }
    }
    
    // 소수 판별 함수
    private boolean isPrime(int n) {
        if (n < 2) return false;
        
        // n의 제곱근까지만 확인하면 충분합니다.
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}