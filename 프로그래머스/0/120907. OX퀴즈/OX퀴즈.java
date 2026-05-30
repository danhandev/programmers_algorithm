class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        
        for (int i = 0; i < quiz.length; i++) {
            String[] tokens = quiz[i].split(" ");
            
            int operator = tokens[1].equals("+") ? 1 : -1;
            int left = Integer.parseInt(tokens[0]) + operator * Integer.parseInt(tokens[2]);
            answer[i] = left == Integer.parseInt(tokens[4]) ? "O" : "X";
        }
        
        return answer;
    }
}