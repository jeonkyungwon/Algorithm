import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	
	static int[][] map;
	static boolean[][] visited;
	static int N;
	
    public static void main(String[] args) throws IOException {        
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	N = Integer.parseInt(br.readLine());
    	
    	map = new int[N][N];
    	visited = new boolean[N][N];
    	
    	for (int i = 0; i < N; i++) {
    		String line = br.readLine();
    		for (int j = 0; j < N; j++) {
    			map[i][j] = line.charAt(j) - '0';
    		}
    	}
    	
    	List<Integer> sizes = new ArrayList<>();
    	int cnt = 0;
       	for (int i = 0; i < N; i++) {
    		for (int j = 0; j < N; j++) {
    			if (map[i][j] == 1 && !visited[i][j]) {
    				cnt++;
    				sizes.add(dfs(i, j));
    			}
    		}
    	}
       	
       	Collections.sort(sizes);
       	System.out.println(cnt);
       	for (int s : sizes) System.out.println(s);
    }
    
    static int dfs(int r, int c) {
        visited[r][c] = true;
        int size = 1;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                if (map[nr][nc] == 1 && !visited[nr][nc]) {
                    size += dfs(nr, nc);
                }
            }
        }
        
        return size;
    }
}