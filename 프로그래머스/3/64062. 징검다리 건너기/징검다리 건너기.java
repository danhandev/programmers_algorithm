class Solution {
    public int solution(int[] stones, int k) {
        int min = 1;
        int max = 200_000_000;
        int mid = min + (max - min) / 2;
        int result = 0;
        
        while (min <= max) {
            mid = min + (max - min) / 2;
            System.out.println(min + " " + mid + " " + max + " " + canCross(k, mid, stones));
            
            if (canCross(k, mid, stones)) {
                result = mid;
                min = mid + 1;
            } else {
                max = mid - 1; 
            }
        }
        return result;
    }
    
    private boolean canCross(int k, int mid, int[] stones) {
        int serialize = 0;
        
        for (int s : stones) {
            if (s < mid) {
                serialize++;
            } else {
                serialize = 0;
            }
            
            if (serialize >= k) {
                return false;
            }
        }
        
        return true;
    }
}