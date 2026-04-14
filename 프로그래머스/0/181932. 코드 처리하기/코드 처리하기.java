class Solution {
    public String solution(String code) {
        StringBuilder ret = new StringBuilder(code.length());
        boolean mode = false;
        
        for (int idx = 0; idx < code.length(); idx++) {
            char current = code.charAt(idx);
            
            if (current == '1') {
                mode = !mode;
                continue;
            }
            
            if (mode == false) {
                if(idx % 2 == 0) {
                    ret.append(current);
                }
            } else {
                if (idx % 2 == 1) {
                    ret.append(current); 
                }
            }
        }
        
        if (ret.toString().equals("")) {
            return "EMPTY";
        }
        
        return ret.toString();
    }
}