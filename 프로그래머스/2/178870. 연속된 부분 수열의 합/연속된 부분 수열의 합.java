import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int n = sequence.length;
        
        int left = 0;
        long sum = 0;
        
        int bestLeft = 0, bestRight = 0;
        int bestLength = Integer.MAX_VALUE;
        
        for (int right = 0; right < n; right++) {
            sum += sequence[right];
            
            // 합이 k를 초과하면 왼쪽을 줄여서 sum <= k로 만든다.
            while (sum > k) {
                sum -= sequence[left++];
            }
            
            // 이제 sum과 같으면 후보 갱신.
            if (sum == k) {
                int length = right - left; // 실제 길이는 len+1, 비교는 len로 해도 동일

                if (length < bestLength || (length == bestLength && left < bestLeft)) {
                    bestLeft = left;
                    bestRight = right;
                    bestLength = length;
                }
            }

        }
                        
        return new int[]{bestLeft, bestRight};
    }
}