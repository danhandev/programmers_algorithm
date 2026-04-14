class Solution {
    public int solution(int[] num_list) {
        int result1 = 1;
        int result2 = 0;
        
        for (int num : num_list) {
            result1 *= num;
            result2 += num;
        }
        
        if (result1 < result2 * result2) {
            return 1;
        } else if (result1 > result2 * result2) {
            return 0;
        }
        return 1;
    }
}