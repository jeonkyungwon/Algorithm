import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int R, C, count = 0;
	static char[][] map;
	static boolean[][] visited;
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	R = Integer.parseInt(st.nextToken());
    	C= Integer.parseInt(st.nextToken());
    	
    	map = new char[R][C];
    	visited = new boolean[R][C];
    	
    	for (int r = 0; r < R; r++) {
            String line = br.readLine();
            for (int c = 0; c < C; c++) {
                map[r][c] = line.charAt(c);
            }
        }
    	
        for (int r = 0; r < R; r++) {
            if (map[r][0] == 'x') continue;
            if (dfs(r, 0)) count++;
        }

        System.out.println(count);
    }
    
    static boolean dfs(int r, int c) {
        visited[r][c] = true;
        
        int[] dr = {-1, 0, 1};
        int[] dc = { 1, 1, 1};
        
        if (c == C - 1) return true;

        for (int d = 0; d < 3; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr < 0 || nr >= R || nc >= C) continue;
            if (map[nr][nc] == 'x' || visited[nr][nc]) continue;

            if (dfs(nr, nc)) return true;
        }

        return false;
    }
}