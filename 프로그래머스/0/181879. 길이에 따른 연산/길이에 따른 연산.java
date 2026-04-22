class Solution {
    public int solution(int[] num_list) {
        int sum = 0;
        int multiple = 1;
        if (num_list.length >= 11) {
            for (int num : num_list) {
                sum += num;
            }
            
            return sum;
        } else {
            for (int num : num_list) {
                multiple *= num;
            }
            
            return multiple;
        }
    }
}