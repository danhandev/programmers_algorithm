class Solution {
    public int solution(int a, int b, int c) {

        int result = 0;
        
        if (a == b && b == c) {
            result = (int) ((a + b + c) * (a * a + b * b + c * c) * (Math.pow(a, 3) + Math.pow(b, 3) + Math.pow(c, 3))); 
        } else if (a != b && b != c && c != a) {
            result = a + b + c;
        } else {
            result = (a + b + c) * (a * a + b * b + c * c);
        }
        
        return result;
    }
}