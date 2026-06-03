class Solution {
    public String solution(String[] id_pw, String[][] db) {
        for (String[] candidate : db) {
            if (candidate[0].equals(id_pw[0])) {
                if (candidate[1].equals(id_pw[1])) return "login";
                else return "wrong pw";
            }
        }
        
        return "fail";
    }
}