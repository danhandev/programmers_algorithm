import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] e : edge) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        int[] dist = new int[n + 1]; // 각 노드까지의 최단 거리 저장 (0은 미방문)
        Arrays.fill(dist, -1);
        Queue<Integer> q = new ArrayDeque<>();

        // 시작점(1번 노드) 설정
        q.add(1);
        dist[1] = 0;

        int maxDist = 0;

        // 3. BFS 탐색
        while (!q.isEmpty()) {
            int curr = q.poll();

            for (int neighbor : graph.get(curr)) {
                if (dist[neighbor] == -1) { // 방문하지 않은 노드라면
                    dist[neighbor] = dist[curr] + 1;
                    maxDist = Math.max(maxDist, dist[neighbor]);
                    q.add(neighbor);
                }
            }
        }

        // 4. 최댓값 거리와 같은 노드 개수 세기
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == maxDist) {
                count++;
            }
        }

        return count;
    }
}