import java.io.*;
import java.util.*;

public class Main {
	
	static int R, C;
	static char[][] forest;
	static boolean[][] visited;
	static int[][] dist;
	static Queue<int[]> water = new ArrayDeque<>();
	static int sr, sc;
	static int[] dr = {0, 0, -1, 1};
	static int[] dc = {-1, 1, 0, 0};
	static int INF = Integer.MAX_VALUE;
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	R = Integer.parseInt(st.nextToken());
    	C = Integer.parseInt(st.nextToken());
    	
    	forest = new char[R][C];
    	for (int r = 0; r < R; r++) {
    		String line = br.readLine();
    		for (int c = 0; c < C; c++) {
    			forest[r][c] = line.charAt(c);
    			if (forest[r][c] == '*') water.offer(new int[] {r, c});
    			else if (forest[r][c] == 'S') {
    				sr = r;
    				sc = c;
    			}
    		}
    	}
    	
    	dist = new int[R][C];
    	for (int i = 0; i < R; i++) {
    		Arrays.fill(dist[i], INF);
    	}
    	spreadWater();
    	
    	visited = new boolean[R][C];
    	int answer = goseumdochi();

    	System.out.println(answer == -1 ? "KAKTUS" : answer);
    }
    
    static void spreadWater() {
    	Queue<int[]> q = new ArrayDeque<>();
    	for (int[] w : water) {
    		dist[w[0]][w[1]] = 0;
    		q.offer(w);
    	}
    	
    	while (!q.isEmpty()) {
    		int[] cur = q.poll();
    		int r = cur[0], c = cur[1];
    		
    		for (int d = 0; d < 4; d++) {
    			int nr = r + dr[d];
    			int nc = c + dc[d];
    			
    			if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
    			if (forest[nr][nc] == 'X' || forest[nr][nc] == 'D') continue;
    			if (dist[nr][nc] != INF) continue;
    			
    			dist[nr][nc] = dist[r][c] + 1;
    			q.offer(new int[] {nr, nc});
    		}
    	
    	}
    }
    
    static int goseumdochi() {
    	Queue<int[]> go = new ArrayDeque<>();
    	go.offer(new int[] {sr, sc, 0});
    	visited[sr][sc] = true;
    	
    	while (!go.isEmpty()) {
    		int[] cur = go.poll();
    		int nowR = cur[0], nowC = cur[1], cnt = cur[2];
    		
    		for (int d = 0; d < 4; d++) {
    			int nr = nowR + dr[d];
    			int nc = nowC + dc[d];

    			if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
    			if (forest[nr][nc] == 'D') return cnt + 1;

    			if (forest[nr][nc] == '.' && !visited[nr][nc] && cnt + 1 < dist[nr][nc]) {
    				visited[nr][nc] = true;
    				go.offer(new int[] {nr, nc, cnt + 1});
    			}
    		}
    	}
    	
    	return -1;
    }
}