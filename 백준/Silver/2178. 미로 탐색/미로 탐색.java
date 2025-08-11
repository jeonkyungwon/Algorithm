import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] maze;
	static int[][] dist;
	static int N, M;
	
    public static void main(String[] args) throws IOException {        
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	
    	maze = new int[N][M];
    	
    	for (int n = 0; n < N; n++) {
    		String line = br.readLine();
    		for (int m = 0; m < M; m++) {
    			maze[n][m] = line.charAt(m) - '0';
    		}
    	}
    	
    	System.out.println(bfs(0, 0));
    }
    
    static int bfs(int sr, int sc) {
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        Queue<int[]> q = new ArrayDeque<>();
        int[][] dist = new int[N][M];

        if (maze[sr][sc] == 0) return -1;

        dist[sr][sc] = 1;
        q.offer(new int[]{sr, sc});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];
            if (r == N - 1 && c == M - 1) return dist[r][c];

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d], nc = c + dc[d];
                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if (maze[nr][nc] == 0) continue;
                if (dist[nr][nc] != 0) continue;
                dist[nr][nc] = dist[r][c] + 1;
                q.offer(new int[]{nr, nc});
            }
        }
        
        return -1;
    }
}