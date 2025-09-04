import java.io.*;
import java.util.*;

public class Main {
	
	static int R, C, answer = 0;
	static char[][] board;
	static boolean[] visited = new boolean[26];
	static int[] dr = {0, 0, -1, 1}, dc = {-1, 1, 0, 0};
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	R = Integer.parseInt(st.nextToken());
    	C = Integer.parseInt(st.nextToken());
    	
    	board = new char[R][C];
    	
    	for (int r = 0; r < R; r++) {
    		String line = br.readLine();
    		for (int c = 0; c < C; c++) {
    			board[r][c] = line.charAt(c);
    		}
    	}
    	
    	visited[board[0][0] - 'A'] = true;
    	dfs(0, 0, 1);
    	System.out.println(answer);
    }
    
    static void dfs(int r, int c, int cnt) {
    	answer = Math.max(answer, cnt);
    	
    	for (int d = 0; d < 4; d++) {
    		int nr = r + dr[d];
    		int nc = c + dc[d];
    		
    		if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
    		
    		int idx = board[nr][nc] - 'A';
    		if (!visited[idx]) {
    			visited[idx] = true;
    			dfs(nr, nc, cnt + 1);
    			visited[idx] = false;
    		}
    	}
    	
    } 
}