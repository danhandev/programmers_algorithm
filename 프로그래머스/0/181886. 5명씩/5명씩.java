class Solution {
    public String[] solution(String[] names) {
        String[] result = new String[(names.length + 4)/ 5];
        int idx = 0;
        
        for (int i = 0; i < names.length; i += 5) {
            result[idx++] = names[i];
        }
        
        return result;
    }
}