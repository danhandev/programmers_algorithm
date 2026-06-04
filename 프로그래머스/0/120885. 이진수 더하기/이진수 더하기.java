class Solution {
    public String solution(String bin1, String bin2) {
        StringBuilder sb = new StringBuilder();
        
        String a = (bin1.length() < bin2.length()) ? bin1 : bin2;
        String b = (bin1.length() < bin2.length()) ? bin2 : bin1;
        
        int ollim = 0;
        for (int i = 1; i <= a.length(); i++) {
            int sum = a.charAt(a.length() - i) - '0' + b.charAt(b.length() - i) - '0' + ollim;

            ollim = (sum >= 2) ? 1 : 0;
            sb.append(sum % 2);
        }
        
        if (b.length() == a.length()) {
            if (ollim == 1) {
                sb.append(1);
            }
        } else {
            for (int i = a.length() + 1; i <= b.length(); i++) {
                int sum = b.charAt(b.length() - i) - '0' + ollim;
                ollim = (sum >= 2) ? 1 : 0;
                sb.append(sum % 2);
            }  
            
            if (ollim == 1) {
                sb.append(1);
            }
        }
      
        return sb.reverse().toString();
    }
}