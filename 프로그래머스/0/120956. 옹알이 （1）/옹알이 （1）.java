class Solution {
    public int solution(String[] babbling) {
        int count = 0;
        for (String b : babbling) {
            b = b.replaceAll("(aya|ye|woo|ma)+", " ");
            b = b.replace(" ", "");
            if (b.isEmpty()) count++;
            System.out.println(b);
        }
        return count;
    }
}