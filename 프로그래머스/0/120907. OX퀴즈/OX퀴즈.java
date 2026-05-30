class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        
        for (int i = 0; i < quiz.length; i++) {
            String[] tokens = quiz[i].split(" ");
            int operand1 = Integer.parseInt(tokens[0]);
            int operand2 = Integer.parseInt(tokens[2]);
            int result = Integer.parseInt(tokens[4]);
            
            if (tokens[1].equals("+")) {
                answer[i] = (operand1 + operand2 == result) ? "O" : "X";
            } else {
                answer[i] = (operand1 - operand2 == result) ? "O" : "X";
            }
        }
        
        return answer;
    }
}