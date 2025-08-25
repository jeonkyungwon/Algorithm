import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
	static int[][] map;
	static boolean[][] visited;
	static int maxHeight = 0, maxArea = 0;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        map = new int[N][N];
        
        for (int i = 0; i < N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	for (int j = 0; j < N; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        		maxHeight = Math.max(maxHeight, map[i][j]);
        	}
        }

        for (int h = 0; h <= maxHeight; h++) {
            visited = new boolean[N][N];
            int cnt = 0;
        	for (int i = 0; i < N; i++) {
        		for (int j = 0; j < N; j++) {
        			if (!visited[i][j] && map[i][j] >= h) {
        				cnt++;
        				dfs(i, j , h);
        			}
        		}
        	}
        	maxArea = Math.max(maxArea, cnt);
        }
        
        System.out.println(maxArea);
    }

    static void dfs(int c, int r, int h) {
    	visited[c][r] = true;
    	
    	int[] dc = {0, 0, -1, 1};
    	int[] dr = {-1, 1, 0, 0};
    	
    	for (int d = 0; d < 4; d++) {
    		int nc = c + dc[d];
    		int nr = r + dr[d];
    		
    		if (nc < 0 || nc >= N || nr < 0 || nr >= N) continue;
    		if (map[nc][nr] >= h && !visited[nc][nr]) {
    			dfs(nc, nr, h);
    		}
    	}
    }
}