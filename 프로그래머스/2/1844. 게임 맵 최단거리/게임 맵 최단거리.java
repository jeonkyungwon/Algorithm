import java.io.*;
import java.util.*;

class Solution {
    
    static int[] dr = {0, 0, -1, 1}, dc = {-1, 1, 0, 0};
    static boolean[][] visited;
    
    public int solution(int[][] maps) {
        int N = maps.length, M = maps[0].length;
        
        visited = new boolean[N][M];
        
        Queue<int[]> q = new ArrayDeque<>();
        visited[0][0] = true;
        q.offer(new int[] {0, 0, 1});
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1], answer = cur[2];
            
            if (r == N - 1 && c == M - 1) return answer;
            
            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d], nc = c + dc[d];
                
                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if (visited[nr][nc] || maps[nr][nc] == 0) continue;
                
                q.offer(new int[] {nr, nc, answer + 1});
                visited[nr][nc] = true;
            }
        }
            
        return -1;
    }

}