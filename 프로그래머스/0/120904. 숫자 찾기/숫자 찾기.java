class Solution {
    public int solution(int num, int k) {
        String strNum = String.valueOf(num);
        
        if (strNum.contains(String.valueOf(k))) {
            return strNum.indexOf(String.valueOf(k)) + 1;
        }
        
        return -1;
    }
}