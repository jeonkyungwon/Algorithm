import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int w, h;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1,-1,-1, 0, 0, 1, 1, 1};
    static int[] dc = {-1, 0, 1,-1, 1,-1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if (w == 0 && h == 0) break;

            map = new int[h][w];
            visited = new boolean[h][w];

            for (int r = 0; r < h; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 0; c < w; c++) {
                    map[r][c] = Integer.parseInt(st.nextToken());
                }
            }

            int cnt = 0;
            for (int r = 0; r < h; r++) {
                for (int c = 0; c < w; c++) {
                    if (map[r][c] == 1 && !visited[r][c]) {
                        bfs(r, c);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }

    static void bfs(int sr, int sc) {
        Queue<int[]> q = new LinkedList<>();
        visited[sr][sc] = true;
        q.offer(new int[]{sr, sc});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];

            for (int d = 0; d < 8; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                
                if (nr < 0 || nc < 0 || nr >= h || nc >= w) continue;
                if (visited[nr][nc]) continue;
                if (map[nr][nc] == 0) continue;

                visited[nr][nc] = true;
                q.offer(new int[]{nr, nc});
            }
        }
    }
}