class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int numer3 = numer1 * denom2 + numer2 * denom1;
        int denom3 = denom1 * denom2;
        
        int resultNumer = numer3;
        int resultDenom = denom3;
        
        for (int n = denom3; n > 0; n--) {
            if (resultNumer % n == 0 && resultDenom % n == 0) {
                resultNumer /= n;
                resultDenom /= n;
            }
        }
        
        return new int[]{resultNumer, resultDenom};
    }
}