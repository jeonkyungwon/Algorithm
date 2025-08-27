import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    
	static int n, m;
	static int[][] map;
	static int[][] dist;
	static int x, y;
	static int[] dr = {0, 0, -1, 1};
	static int[] dc = {-1, 1, 0, 0};
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j = 0; j < m; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        		if (map[i][j] == 2) {
        			x = i;
        			y = j;
        		}        		
        	}
        }
        
        dist = new int[n][m];
        for (int i = 0; i < n ; i++) {
        	for (int j = 0; j < m; j++) {
        		if (map[i][j] == 1) dist[i][j] = -1;
        		else dist[i][j] = 0;
        	}
        }
        
        bfs(x, y, 0);
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n ; i++) {
        	for (int j = 0; j < m; j++) {
        		sb.append(dist[i][j]).append(" ");
        	}
        	sb.append("\n");
        }
        
        System.out.println(sb);
    }
    
    static void bfs(int r, int c, int d) {
    	Queue<int[]> q = new LinkedList<>();
    	dist[r][c] = d;
    	q.offer(new int[] {r, c});
    	
    	while (!q.isEmpty()) {
    		int[] cur = q.poll();
    		int sr = cur[0], sc = cur[1];
    		
    		for (int w = 0; w < 4; w++) {
    			int nr = sr + dr[w];
    			int nc = sc + dc[w];
    			
    			if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
    			if (map[nr][nc] == 1 && dist[nr][nc] == -1) {
    				dist[nr][nc] = dist[sr][sc] + 1;
    				q.offer(new int[] {nr, nc});
    			}
    		}
    	}
    }
}