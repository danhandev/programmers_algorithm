class Solution {
    public String solution(int[] numLog) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < numLog.length - 1; i++) {
            int diff = numLog[i + 1] - numLog[i];
            
            char code = switch(diff) {
                case +1 -> 'w';
                case -1 -> 's';
                case +10 -> 'd';
                case -10 -> 'a';
                default -> ' ';
            };
            
            sb.append(code);
        }
        return sb.toString();
    }
}