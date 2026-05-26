class Solution {
    public int[] solution(int[] numbers, String direction) {
        int dx = 0;
        
        if (direction.equals("left")) {
            dx = 1;
        } else {
            dx = -1;
        }
        int[] answer = new int[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            int newIndex = i + dx;
            
            if (newIndex == -1) {
                newIndex = numbers.length - 1;
            } else if (newIndex == numbers.length) {
                newIndex = 0;
            }
            
            answer[i] = numbers[newIndex];
        }
        
        return answer;
    }
}