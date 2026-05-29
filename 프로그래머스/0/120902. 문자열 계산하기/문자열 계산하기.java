class Solution {
    public int solution(String my_string) {
        String[] factors = my_string.split(" ");
        int result = Integer.parseInt(factors[0]);
        
        for (int i = 1; i < factors.length; i += 2) {
            if ("+".equals(factors[i])) {
                result += Integer.parseInt(factors[i + 1]);
            } else if ("-".equals(factors[i])) {
                result -= Integer.parseInt(factors[i + 1]);
            }
        }
        return result;
    }
}