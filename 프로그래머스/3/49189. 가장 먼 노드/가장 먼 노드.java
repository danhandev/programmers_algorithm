import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        // 간선 그래프 초기화
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edge.length; i++) {
            graph.get(edge[i][0] - 1).add(edge[i][1] - 1);
            graph.get(edge[i][1] - 1).add(edge[i][0] - 1);
        }   
        
        // 거리 배열, 미방문 시 -1
        int[] distance = new int[n];
        Arrays.fill(distance, -1);
        
        int maxDistance = -1;
        
        // 방문할 노드
        Queue<Integer> q = new ArrayDeque<>();
        
        // 시작 노드 세팅
        q.add(0);
        distance[0] = 0;
        
        while (!q.isEmpty()) {
            int current = q.poll();
            
            for (int neighbor : graph.get(current)) {
                if (distance[neighbor] == -1) {
                    distance[neighbor] = distance[current] + 1;
                    q.add(neighbor);
                    maxDistance = Math.max(maxDistance, distance[neighbor]);
                }
            }
        }
        
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (distance[i] == maxDistance) {
                count++;
            }
        }
        
        return count;
    }
}