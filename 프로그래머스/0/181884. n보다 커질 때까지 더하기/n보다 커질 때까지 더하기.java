class Solution {
    public int solution(int[] numbers, int n) {

        int sum = 0;
        
        for (int num : numbers) {
            if (sum > n) {
                return sum;
            }
            
            sum += num;
        }
        
        return sum;
    }
}