import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class Solution {
    static class Song {
        int id, plays;
        Song(int id, int plays) { this.id = id; this.plays = plays; }
    }

    // a가 b보다 "우선순위가 높으면" true
    private boolean better(Song a, Song b) {
        if (b == null) return true;
        if (a.plays != b.plays) return a.plays > b.plays;
        return a.id < b.id;
    }

    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> total = new HashMap<>();
        Map<String, Song[]> top2 = new HashMap<>(); // [0]=1등, [1]=2등

        for (int i = 0; i < genres.length; i++) {
            String g = genres[i];
            int p = plays[i];

            total.put(g, total.getOrDefault(g, 0) + p);

            Song cur = new Song(i, p);
            Song[] best = top2.computeIfAbsent(g, k -> new Song[2]);

            // 1등 갱신
            if (better(cur, best[0])) {
                best[1] = best[0];
                best[0] = cur;
            }
            // 2등 갱신
            else if (better(cur, best[1])) {
                best[1] = cur;
            }
        }

        List<String> genreOrder = new ArrayList<>(total.keySet());
        genreOrder.sort((a, b) -> Integer.compare(total.get(b), total.get(a)));

        List<Integer> answer = new ArrayList<>();
        for (String g : genreOrder) {
            Song[] best = top2.get(g);
            answer.add(best[0].id);
            if (best[1] != null) answer.add(best[1].id);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
