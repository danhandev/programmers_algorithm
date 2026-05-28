class Solution {
    public int solution(int order) {
        int count = 0;
        
        while (order > 1) {
            int num = order % 10;
            if (num == 3 || num == 6 || num == 9) {
                count++;
            }
            
            order /= 10;
        }
        return count;
    }
}