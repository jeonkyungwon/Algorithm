import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] map;
	static boolean[][] visited;
	static int w, h;
	
    public static void main(String[] args) throws IOException {        
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	while (true) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
        	w = Integer.parseInt(st.nextToken());
        	h = Integer.parseInt(st.nextToken());
        	
        	if (w == 0 && h == 0) {
        		break;
        	}
        	
        	map = new int[h][w];
        	visited = new boolean[h][w];
        	
        	for (int i = 0; i < h; i++) {
        		st = new StringTokenizer(br.readLine());
        		for (int j = 0; j < w; j++) {
        			map[i][j] = Integer.parseInt(st.nextToken());
        		}
        	}
        	
        	int cnt = 0;
        	for (int i = 0; i < h; i++) {
        		for (int j = 0; j < w; j++) {
        			if (map[i][j] == 1 && !visited[i][j]) {
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
    	
    	int[] dc = {0, 0, -1, 1, -1, -1, 1, 1};
    	int[] dr = {-1, 1, 0, 0, -1, 1, -1, 1}; 
    	
    	for(int d = 0; d < 8; d++) {
    		int nc = c + dc[d];
    		int nr = r + dr[d];
    		
    		if (nc >= 0 && nc < h && nr >= 0 && nr < w) {
    			if (map[nc][nr] == 1 && !visited[nc][nr]) {
        			dfs(nc, nr);	
    			}
    		}
    	}
    }   
}