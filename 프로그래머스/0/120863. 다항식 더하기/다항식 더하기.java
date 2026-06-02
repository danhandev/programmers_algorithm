class Solution {
    public String solution(String polynomial) {
        String[] operands = polynomial.split(" ");
        int[] result = {0, 0};
        
        for (String o : operands) {
            if (o.charAt(0) == '+') {
                continue;
            } else if (o.charAt(o.length() - 1) == 'x') {
                if (o.charAt(0) == 'x') {
                    result[0] += 1;
                } else {
                    result[0] += Integer.parseInt(o.substring(0, o.length() - 1));
                }
            } else {
                result[1] += Integer.parseInt(o);
            }
            
            System.out.print(result[0] + " " + result[1] + "\n");
        }
        
        StringBuilder sb = new StringBuilder();
        if (result[0] != 0) {
            sb.append(result[0] == 1 ? "x" : result[0] + "x");
            
            if (result[1] != 0) {
                sb.append(" + " + result[1]);
            }
        } else {
            sb.append(result[1]);
        }

        
        return sb.toString();
    }
}