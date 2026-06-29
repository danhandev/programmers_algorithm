class Solution {
    public int solution(int left, int right) {
        int sum = 0;
        for (int n = left; n <= right; n++) {
            sum += ((countYaksu(n) % 2 == 0) ? (1) : (-1)) * n;
        }
        return sum;
    }
    
    private int countYaksu(int num) {
        int count = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                count++;
            }
        }
        return count;
    }
}