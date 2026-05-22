class Solution {
    public int solution(int n) {
//         int nSqrt = Math.sqrt(n);
//         int plus = (nSqrt )
        int count = 0;
        
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                count++;
            }

        }
        return count;
    }
}