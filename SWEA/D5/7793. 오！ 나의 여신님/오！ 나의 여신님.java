import java.io.*;
import java.util.*;

public class Solution {
	
	static int[] dr = {0, 0, -1, 1}, dc = {-1, 1, 0, 0};
	static int N, M, sr, sc;
	static char[][] map;
	static Queue<int[]> devil = new ArrayDeque<>();
	static int[][] devilArea;
	static boolean[][] visited;
	static int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int T = Integer.parseInt(br.readLine());
    	
    	for (int t = 1; t <= T; t++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		N = Integer.parseInt(st.nextToken());
    		M = Integer.parseInt(st.nextToken());
    		
    		devil = new ArrayDeque<>();
    		map = new char[N][M];
    		for (int i = 0; i < N; i++) {
    			String line = br.readLine();
    			for (int j = 0; j < M; j++) {
    				map[i][j] = line.charAt(j);
    				
    				if (map[i][j] == 'S') {
    					sr = i;
    					sc = j;
    				} else if (map[i][j] == '*') devil.offer(new int[] {i, j});
    				
    			}
    		}
    		
    		devilArea = new int[N][M];
    		for (int i = 0; i < N; i++) {
    			Arrays.fill(devilArea[i], INF);
    		}
    		
    		devilSpread();

    		visited = new boolean[N][M];
    		int answer = suyeon();
    		
    		System.out.print("#" + t + " ");
    		System.out.println(answer == -1 ? "GAME OVER" : answer);
    	}
    }
    
    static void devilSpread() {
    	Queue<int[]> q = new ArrayDeque<>();
    	for (int[] d : devil) {
    		devilArea[d[0]][d[1]] = 0;
    		q.offer(d);
    	}
    	
    	while (!q.isEmpty()) {
    		int[] cur = q.poll();
    		int r = cur[0], c = cur[1];
    		
    		for (int d = 0; d < 4; d++) {
    			int nr = r + dr[d];
    			int nc = c + dc[d];
    			
    			if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
    			if (map[nr][nc] == 'X' || map[nr][nc] == 'D') continue;
    			if (devilArea[nr][nc] != INF) continue;
    			
    			devilArea[nr][nc] = devilArea[r][c] + 1;
    			q.offer(new int[] {nr, nc});
    		}
    	}
    }
    
    static int suyeon() {
    	Queue<int[]> q = new ArrayDeque<>();
    	visited[sr][sc] = true;
    	q.offer(new int[] {sr, sc, 0});
    	
    	while(!q.isEmpty()) {
    		int[] cur = q.poll();
    		int r = cur[0], c = cur[1], time = cur[2];
    		
    		for (int d = 0; d < 4; d++) {
    			int nr = r + dr[d];
    			int nc = c + dc[d];
    			    			
    			if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
    			if (map[nr][nc] == 'D') return time + 1;
    			
    			if (map[nr][nc] == '.' && !visited[nr][nc] && time + 1 < devilArea[nr][nc]) {
    				visited[nr][nc] = true;
    				q.offer(new int[] {nr, nc, time + 1});
    			}
    		}
    	}
    	
    	return -1;
    }
}