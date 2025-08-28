import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    
	static int N, M;
	static int[][] map;
	static int[][][] dist;
	static int[] dr = {0, 0, -1, 1}, dc = {-1, 1, 0, 0};
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new int[N][M];        
        for (int i = 0; i < N; i++) {
        	String line = br.readLine();
        	for (int j = 0; j < M; j++) {
        		map[i][j] = line.charAt(j) - '0';
        	}
        }
        
        System.out.println(bfs());
    }
    
    static int bfs() {
        dist = new int[N][M][2];    	
    	ArrayDeque<int[]> q = new ArrayDeque<>();
    	
    	dist[0][0][0] = 1;
    	q.offer(new int[] {0, 0, 0});
    	
    	while(!q.isEmpty()) {
    		int[] cur = q.poll();
    		int r = cur[0], c = cur[1], b = cur[2];
    		int cnt = dist[r][c][b];
    		
    		if (r == N - 1 && c == M - 1) return cnt;
    		
    		for (int d = 0; d < 4; d++) {
    			int nr = r + dr[d];
    			int nc = c + dc[d];
    		
    			if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
    			if (map[nr][nc] == 0) {
    				if (dist[nr][nc][b] == 0) {
    					dist[nr][nc][b] = cnt + 1;
    					q.offer(new int[] {nr, nc, b});
    				}
    			} else {
    				if (b == 0 && dist[nr][nc][1] == 0) {
                        dist[nr][nc][1] = cnt + 1;
                        q.offer(new int[]{nr, nc, 1});
    				}
    			}
    		}
    	}
    	
    	return -1; 
    }
}