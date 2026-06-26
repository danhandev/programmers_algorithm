import java.util.*;

class Solution {
    public int solution(String message, int[][] spoiler_ranges) {
        int n = message.length();
        
        // 1. 스포일러 영역을 지도처럼 표시하기
        boolean[] isSpoilerPos = new boolean[n];
        for (int[] range : spoiler_ranges) {
            for (int i = range[0]; i <= range[1]; i++) {
                isSpoilerPos[i] = true;
            }
        }

        List<String> spoilerWordsSequence = new ArrayList<>(); // 왼쪽부터 발견되는 스포 단어 순서
        Set<String> normalWords = new HashSet<>();            // 일반 구간에 "한 번이라도" 등장한 단어들

        StringBuilder currentWord = new StringBuilder();
        boolean currentWordHasSpoiler = false;

        // 2. 메시지를 한 글자씩 넘기며 단어 추출 및 스포 여부 판별
        for (int i = 0; i <= n; i++) {
            if (i == n || message.charAt(i) == ' ') {
                if (currentWord.length() > 0) {
                    String wordStr = currentWord.toString();
                    
                    if (currentWordHasSpoiler) {
                        spoilerWordsSequence.add(wordStr);
                    } else {
                        // 스포일러가 단 한 글자도 안 묻은 순수 일반 단어라면 무조건 기록!
                        normalWords.add(wordStr);
                    }
                    
                    currentWord.setLength(0);
                    currentWordHasSpoiler = false;
                }
            } else {
                currentWord.append(message.charAt(i));
                if (isSpoilerPos[i]) {
                    currentWordHasSpoiler = true;
                }
            }
        }

        // 3. 왼쪽 스포 단어부터 차례대로 열어보며 "중요한 단어" 카운트
        int importantWordCount = 0;
        Set<String> seenSpoilerWords = new HashSet<>(); // 이미 앞에서 등장한 스포 단어 체크

        for (String word : spoilerWordsSequence) {
            // 조건 3: 이전에 이미 나온 스포 단어면 무시
            if (seenSpoilerWords.contains(word)) {
                continue;
            }
            seenSpoilerWords.add(word);

            // 조건 2: 일반 구간(normalWords)에 단 한 번이라도 등장한 적이 없어야 함!
            if (!normalWords.contains(word)) {
                importantWordCount++;
            }
        }

        return importantWordCount;
    }
}