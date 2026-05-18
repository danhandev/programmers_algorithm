class Solution {
    public int solution(String my_string, String target) {
        for (int i = 0; i < my_string.length() - target.length() + 1; i++) {
            if (target.equals(my_string.substring(i, i + target.length()))) {
                return 1;
            }
        }
        
        return 0;
    }
}