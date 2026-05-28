class Solution {
    public int solution(String s) {
        String[] list = s.split(" ");
        int sum = 0;
        
        for (int i = 0; i < list.length; i++) {
            if (list[i].equals("Z")) {
                sum -= Integer.parseInt(list[i-1]);
            } else {
                sum += Integer.parseInt(list[i]);
            }
        }
        return sum;
    }
}