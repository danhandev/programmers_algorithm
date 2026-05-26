class Solution {
    public int solution(int[] numbers, int k) {

        int current = 0;
        
        for (int i = 0; i < k - 1; i++) {
            current = (current + 2) % numbers.length;
        }
        
        return current + 1;
    }
}