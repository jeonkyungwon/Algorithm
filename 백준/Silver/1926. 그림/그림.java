import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int n, m;
	static int[][] paper;
	static boolean[][] visited;
	static int cnt = 0, maxExtent = 0;
	
    public static void main(String[] args) throws IOException {        
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	n = Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());
    	
    	paper = new int[n][m];
    	for (int i = 0; i < n; i++) {
    		st = new StringTokenizer(br.readLine());
    		for (int j = 0; j < m; j++) {
    			paper[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	visited = new boolean[n][m];
    	for (int i = 0; i < n; i++) {
    		for (int j = 0; j < m; j++) {
    			if (paper[i][j] == 1 && !visited[i][j]) {
        			cnt++;
        			int currentExtent = dfs(i, j);
        			maxExtent = Math.max(maxExtent, currentExtent);
    			}
    		}
    	}
    	
    	System.out.println(cnt);
    	System.out.println(maxExtent);
    }
    
    static int dfs(int r, int c) {
    	visited[r][c] = true;
    	int extent = 1;
    	
    	int[] dr = {0, 0, -1, 1};
    	int[] dc = {-1, 1, 0, 0};
    	
    	for (int d = 0; d < 4; d++) {
    		int nr = r + dr[d];
    		int nc = c + dc[d];
    		
    		if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
    			if (paper[nr][nc] == 1 && !visited[nr][nc]) {
    				extent += dfs(nr, nc);
    			}
    		}
    	}

    	return extent;
    }
}