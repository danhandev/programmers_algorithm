class Solution {
    public int solution(int[] stones, int k) {   
        int min = 1;
        int max = 200000000;
        int answer = 0;
        
        while (min <= max) {
            int mid = min + (max - min) / 2;

            // mid 명의 인원이 건널 수 있는지 확인
            if (canCross(stones, k, mid)) {
                answer = mid;
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        
        return answer;
    }
    
    private boolean canCross(int[] stones, int k, int mid) {
        int skipCount = 0;
        
        for (int stone : stones) {
            if (stone < mid) {
                skipCount++;
                
                if (skipCount >= k) {
                    return false;
                }
            } else {
                skipCount = 0;
            }
        }
        
        return true;
    }
}