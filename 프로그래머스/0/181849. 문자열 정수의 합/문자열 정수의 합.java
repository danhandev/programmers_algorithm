class Solution {
    public int solution(String num_str) {
        int digitSum = 0;
        
        for (int i = 0; i < num_str.length(); i++) {
            digitSum += (int) (num_str.charAt(i) - '0');
        }
        
        return digitSum;
    }
}