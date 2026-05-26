class Solution {
    public String solution(String letter) {
        String[] morseInput = letter.split(" ");
        String[] convertor = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < morseInput.length; i++) {
            for (int j = 0; j < convertor.length; j++) {
                if (convertor[j].equals(morseInput[i])) { 
                    sb.append((char) (j + 'a'));
                }
            }
        }
        
        return sb.toString();
    }
}