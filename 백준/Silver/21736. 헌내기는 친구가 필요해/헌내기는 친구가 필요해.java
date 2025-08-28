import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
	static int N, M, cnt = 0;
	static char[][] campus;
	static boolean[][] visited;
	static int sr, sc;
	static int[] dr = {0, 0, -1, 1};
	static int[] dc = {-1, 1, 0, 0};
		
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        campus = new char[N][M];
        visited = new boolean[N][M];
        
        for (int i = 0; i < N; i++) {
        	String line = br.readLine();
        	for (int j = 0; j < M; j++) {
        		campus[i][j] = line.charAt(j);
        		if (campus[i][j] == 'I') {
        			sr = i; 
        			sc = j;
        		}
        	}
        }
        
        dfs(sr, sc);
        
        if (cnt == 0) System.out.println("TT");
        else System.out.println(cnt);
    }
    
    static void dfs(int r, int c) {
    	visited[r][c] = true;
    	
    	for (int d = 0; d < 4; d++) {
    		int nr = r + dr[d];
    		int nc = c + dc[d];
    		
    		if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
    		if (!visited[nr][nc]) {
	    		if (campus[nr][nc] == 'O') {
	    			dfs(nr, nc);
	    		}
	    		else if (campus[nr][nc] == 'P') {
	    			cnt++;
	    			dfs(nr, nc);
	    		}
    		}
    	}
    }     
}