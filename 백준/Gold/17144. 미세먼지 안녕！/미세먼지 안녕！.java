import java.io.*;
import java.util.*;

public class Main {

    static int R, C, T, ap;
    static int[][] home;
    static int[] dr = {-1, 0, 1, 0}, dc = {0, -1, 0, 1};
    static List<int[]> dust = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        home = new int[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                home[i][j] = Integer.parseInt(st.nextToken());
                if (home[i][j] == -1) ap = i;
            }
        }

        for (int t = 0; t < T; t++) {
            dust = findDust();
            spreadDust();
            operate();
        }

        int cnt = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (home[i][j] > 0) cnt += home[i][j];
            }
        }

        System.out.println(cnt);
    }

    static List<int[]> findDust() {
        dust = new ArrayList<>();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (home[i][j] > 0) dust.add(new int[]{i, j, home[i][j] / 5});
            }
        }

        return dust;
    }

    static void spreadDust() {
        for (int[] d: dust) {
            for (int i = 0; i < 4; i++) {
                if (d[0] + dr[i] < 0 || d[1] + dc[i] < 0 || d[0] + dr[i] >= R || d[1] + dc[i] >= C || home[d[0] + dr[i]][d[1] + dc[i]] == -1) continue;
                home[d[0] + dr[i]][d[1] + dc[i]] += d[2];
                home[d[0]][d[1]] -= d[2];
            }
        }
    }

    static void operate() {
        for (int r = ap - 3; r >= 0; r--) {
            home[r + 1][0] = home[r][0];
        }
        for (int c = 0; c < C - 1; c++) {
            home[0][c] = home[0][c + 1];
        }
        for (int r = 0; r < ap - 1; r++) {
            home[r][C - 1] = home[r + 1][C - 1];
        }
        for (int c = C - 2; c > 0; c--) {
            home[ap - 1][c + 1] = home[ap - 1][c];
        }
        home[ap - 1][1] = 0;

        for (int r = ap + 2; r < R; r++) {
            home[r - 1][0] = home[r][0];
        }
        for (int c = 1; c < C; c++) {
            home[R - 1][c - 1] = home[R - 1][c];
        }
        for (int r = R - 2; r >= ap; r--) {
            home[r + 1][C - 1] = home[r][C - 1];
        }
        for (int c = C - 2; c >= 1; c--) {
            home[ap][c + 1] = home[ap][c];
        }
        home[ap][1] = 0;
    }
}