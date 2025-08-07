import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] land;
	static boolean[][] visited;
	
    public static void main(String[] args) throws IOException {        
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int T = Integer.parseInt(br.readLine());
    	
    	for (int t = 0; t < T; t++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
        	int M = Integer.parseInt(st.nextToken());
        	int N = Integer.parseInt(st.nextToken());
        	int K = Integer.parseInt(st.nextToken());

    		land = new int[N][M];
    		visited = new boolean[N][M];
    		
        	for (int k = 0; k < K; k++) {
        		st = new StringTokenizer(br.readLine());
        		int X = Integer.parseInt(st.nextToken());
        		int Y = Integer.parseInt(st.nextToken());
        		
        		land[Y][X] = 1;
        	}
        	
    		int cnt = 0;
        	for (int i = 0; i < N; i++) {
        		for (int j = 0; j < M; j++) {
        			if (land[i][j] == 1 && !visited[i][j]) {
        				cnt++;
        				dfs(i, j);
        			}
        		}
        	}
        	
        	System.out.println(cnt);
    	}
    }
    
    static void dfs(int c, int r) {
    	visited[c][r] = true;
    	
    	int[] dx = {0, 0, -1, 1};
    	int[] dy = {-1, 1, 0, 0};
    	
    	for (int d = 0; d < 4; d++) {
    		int nc = c + dy[d];
    		int nr = r + dx[d];
    		
    		if (nc >= 0 && nc < land.length && nr >= 0 && nr < land[0].length) {
    			if (land[nc][nr] == 1 && !visited[nc][nr]) {
    				dfs(nc, nr);
    			}
    		}
    	}
    }
}