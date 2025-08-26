import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int M, N;
    static int[][] tomatoes;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        tomatoes = new int[N][M];

        Queue<int[]> q = new LinkedList<>();

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                tomatoes[r][c] = Integer.parseInt(st.nextToken());
                if (tomatoes[r][c] == 1) {
                    q.offer(new int[]{r, c});
                }
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if (tomatoes[nr][nc] != 0) continue;

                tomatoes[nr][nc] = tomatoes[r][c] + 1;
                q.offer(new int[]{nr, nc});
            }
        }

        int maxVal = 1;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (tomatoes[r][c] == 0) {
                    System.out.println(-1);
                    return;
                }
                maxVal = Math.max(maxVal, tomatoes[r][c]);
            }
        }
        System.out.println(maxVal - 1);
    }
}