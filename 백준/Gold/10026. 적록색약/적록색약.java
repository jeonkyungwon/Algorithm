import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static char[][] grid;
	static boolean[][] visited;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        grid = new char[N][N];
        visited = new boolean[N][N];
        
        for (int i = 0; i < N; i++) {
        	String line = br.readLine();
        	for (int j = 0; j < N; j++) {
        		grid[i][j] = line.charAt(j);
        	}
        }
        
        int cnt = 0;
        for (int i = 0; i < N; i++) {
        	for (int j = 0; j < N; j++) {
                if (grid[i][j] == 'R' && !visited[i][j]) {
            		dfs(i, j, 'R');	
            		cnt++;
                } else if (grid[i][j] == 'G' && !visited[i][j]) {
            		dfs(i, j, 'G');	
            		cnt++;
                } else if (grid[i][j] == 'B' && !visited[i][j]) {
            		dfs(i, j, 'B');	
            		cnt++;
                }
        	}
        }
        
        visited = new boolean[N][N];
        int rgCnt = 0;
        for (int i = 0; i < N; i++) {
        	for (int j = 0; j < N; j++) {
                if ((grid[i][j] == 'R' || grid[i][j] == 'G') && !visited[i][j]) {
                	rgDfs(i, j, 'R');	
            		rgCnt++;
                } else if (grid[i][j] == 'B' && !visited[i][j]) {
                	rgDfs(i, j, 'B');	
            		rgCnt++;
                }
        	}
        }
        
        System.out.println(cnt + " " + rgCnt);
    }
    
    static void dfs(int c, int r, char color) {
    	visited[c][r] = true;
    	
    	int[] dc = {0, 0, -1, 1};
    	int[] dr = {-1, 1, 0, 0};
    	
    	for (int d = 0; d < 4; d++) {
    		int nc = c + dc[d];
    		int nr = r + dr[d];
    		
    		if (nc < 0 || nc >= N || nr < 0 || nr >= N) continue;
    		if (grid[nc][nr] == color && !visited[nc][nr]) {
    			dfs(nc, nr, color);
    		}
    	}
    }
    
    static void rgDfs(int c, int r, char color) {
    	visited[c][r] = true;
    	
    	int[] dc = {0, 0, -1, 1};
    	int[] dr = {-1, 1, 0, 0};
    	
    	for (int d = 0; d < 4; d++) {
    		int nc = c + dc[d];
    		int nr = r + dr[d];
    		
    		if (nc < 0 || nc >= N || nr < 0 || nr >= N) continue;
    		if (color == 'R') {
    			if ((grid[nc][nr] == 'R' || grid[nc][nr] == 'G') && !visited[nc][nr]) {
    				rgDfs(nc, nr, color);
        		}	
    		} else {
	    		if (grid[nc][nr] == color && !visited[nc][nr]) {
	    			rgDfs(nc, nr, color);
	    		}
    		}
    	}
    }
}