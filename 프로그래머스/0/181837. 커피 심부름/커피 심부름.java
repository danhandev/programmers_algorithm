class Solution {
    public int solution(String[] order) {
        int americanoCount = 0;
        int latteCount = 0;
        
        for (String o : order) {
            if (o.indexOf("americano") > -1) {
                americanoCount++;
            } else if (o.indexOf("latte") > -1) {
                latteCount++;
            } else if (o.indexOf("anything") > -1) {
                americanoCount++;
            }
        }
        
        return americanoCount * 4500 + latteCount * 5000;
    }
}