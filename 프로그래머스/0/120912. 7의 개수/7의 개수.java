class Solution {
    public int solution(int[] array) {
        int totalCount = 0;
        
        for (int n : array) {
            totalCount += count7(n);
        }
        return totalCount;
    }
    
    private int count7(int number) {
        int count = 0;
        
        while (number > 1) {
            if (number % 10 == 7) {
                count++;
            }
            
            number /= 10;
        }
        
        return count;
    }
}