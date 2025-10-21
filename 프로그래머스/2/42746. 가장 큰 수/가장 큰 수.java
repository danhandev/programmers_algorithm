import java.util.PriorityQueue;
import java.util.Comparator;

/*
* 먼저 떠올린 아이디어 = 각 number에서 가장 큰 자리수 숫자가 클 수록 먼저 배치해야함
* -> 반례 [121, 12] 12+121 = 12121 vs 121+12 = 12112 → 12가 먼저 와야함
* -> 문자열 두 수를 붙여본 결과(ab vs ba)로 비교해야함
*/
class Solution {
    public String solution(int[] numbers) {
        Comparator<String> cmp = (a, b) -> (b + a).compareTo(a + b);
        PriorityQueue<String> pq = new PriorityQueue<>(cmp);

        for (int n : numbers) pq.offer(String.valueOf(n));
        if (pq.peek().equals("0")) return "0";

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) sb.append(pq.poll());
        return sb.toString();
    }
}

