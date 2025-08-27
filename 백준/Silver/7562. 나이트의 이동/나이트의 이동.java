import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	static int T, I, sx, sy, ex, ey;
	static int[] dr = {-2, -1, 1, 2, 2, 1, -1, -2};
	static int[] dc = {1, 2, 2, 1, -1, -2, -2, -1};
	static boolean[][] visited;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        
        for(int t = 0; t < T; t++) {
        	I = Integer.parseInt(br.readLine());
        	visited = new boolean[I][I];
        	
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	sx = Integer.parseInt(st.nextToken());
        	sy = Integer.parseInt(st.nextToken());
        	
        	st = new StringTokenizer(br.readLine());
        	ex = Integer.parseInt(st.nextToken());
        	ey = Integer.parseInt(st.nextToken());
        	
        	int answer = move(sx, sy);
        	
        	System.out.println(answer);
        }
    }
    
    static int move(int r, int c) {    
        if (r == ex && c == ey) return 0;

        ArrayDeque<int[]> q = new ArrayDeque<>();
    	visited[r][c] = true;
    	q.offer(new int[] {r, c, 0});
    	
    	while (!q.isEmpty()) {
    		int[] cur = q.poll();
    		int sr = cur[0], sc = cur[1], scnt = cur[2];
    		
    		for (int d = 0; d < 8; d++) {
    			int nr = sr + dr[d];
    			int nc = sc + dc[d];
    			
    			if (nr < 0 || nr >= I || nc < 0 || nc >= I) continue;
    			
    			if (nr == ex && nc == ey) return scnt + 1;
    			
    			if (!visited[nr][nc]) {
    				visited[nr][nc] = true;
    				q.offer(new int[] {nr, nc, scnt + 1});
    			}
    		}
    	}
    	
    	return -1;
    }
}