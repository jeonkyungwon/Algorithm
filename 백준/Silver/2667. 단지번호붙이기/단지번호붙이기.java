import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {0, 0, -1, 1}, dc = {-1, 1, 0, 0};
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        map = new int[N][N];
        for (int n = 0; n < N; n++) {
        	String line = br.readLine();
        	for (int i = 0; i < line.length(); i++) {
        		map[n][i] = line.charAt(i) - '0';
        	}
        }
        
        visited = new boolean[N][N];
        int total = 0;
        List<Integer> count = new ArrayList<>();
        for (int i = 0; i < N; i++) {
        	for (int j = 0; j < N; j++) {
        		if (!visited[i][j] && map[i][j] == 1) {
        			count.add(bfs(i, j));
        			total++;
        		}
        	}
        }
        
        Collections.sort(count);
        
        System.out.println(total);
        for (int i = 0; i < total; i++) {
        	System.out.println(count.get(i));
        }
        
    }
    
    static int bfs(int r, int c) {
    	Queue<int[]> q = new ArrayDeque<>();
    	visited[r][c] = true;
    	q.offer(new int[] {r, c});
    	int cnt = 1;
    	
    	while (!q.isEmpty()) {
    		int[] cur = q.poll();
    		int cr = cur[0], cc = cur[1];

    		for (int d = 0; d < 4; d++) {
    			int nr = cr + dr[d], nc = cc + dc[d];
    			
    			if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
    			if (visited[nr][nc] || map[nr][nc] == 0) continue;
    			visited[nr][nc] = true;
    			q.offer(new int[] {nr, nc});
    			cnt++;
    		}
    	}

    	return cnt;
    }
}