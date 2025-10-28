import java.io.*;
import java.util.*;

public class Solution {
	
	static int[] dr = {0, 0, -1, 1}, dc = {-1, 1, 0, 0};
	static int[][] pool;
	static boolean[][] visited;
	static int N, A, B, C, D;
	
    public static void main(String[] args) throws IOException {  
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
		int T = Integer.parseInt(br.readLine());
    	for (int t = 1; t <= T; t++) {
    		N = Integer.parseInt(br.readLine());
    		pool = new int[N][N];
    		visited = new boolean[N][N];
    		
    		for (int i = 0; i < N; i++) {
    			StringTokenizer st = new StringTokenizer(br.readLine());
    			for (int j = 0; j < N; j++) {
    				pool[i][j] = Integer.parseInt(st.nextToken());
    			}
    		}
    		
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		A = Integer.parseInt(st.nextToken());
    		B = Integer.parseInt(st.nextToken());
    		
    		st = new StringTokenizer(br.readLine());
    		C = Integer.parseInt(st.nextToken());
    		D = Integer.parseInt(st.nextToken());
    		
    		int answer = bfs();
    		
    		System.out.println("#" + t + " " + answer);
    	}
    }
    
    static int bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {A, B, 1});
		visited[A][B] = true;
		
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int r = cur[0], c = cur[1], time = cur[2];
			
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d], nc = c + dc[d];
				
				if (nr == C && nc == D) return time;
				
				if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
				if (visited[nr][nc] || pool[nr][nc] == 1) continue;
				
				q.offer(new int[] {nr, nc, time + 1});
				visited[nr][nc] = true;
			}			
		}
		
    	return -1;
    }
}