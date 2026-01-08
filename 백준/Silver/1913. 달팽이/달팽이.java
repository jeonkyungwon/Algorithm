import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static int[] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};
    static int[] target;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        int[][] snail = CreateSnail();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(snail[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);

        sb = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            sb.append(target[i]).append(" ");
        }
        System.out.println(sb);
    }

    static int[][] CreateSnail() {
        int[][] snail = new int[N][N];
        int r = N / 2, c = N / 2;
        int i = 1, d = 0, j = 1, cnt = 0;

        target = new int[2];
        snail[r][c] = 1;
        if (i == M) {
            target[0] = r + 1;
            target[1] = c + 1;
        }
        i++;

        while (i <= N * N) {
            for (int a = 0; a < j; a++) {
                r += dr[d % 4];
                c += dc[d % 4];

                if (i == M) {
                    target[0] = r + 1;
                    target[1] = c + 1;
                }

                snail[r][c] = i;
                i++;

                if (i > N * N) {
                    break;
                }
            }
            cnt++;
            d++;

            if (cnt == 2) {
                cnt = 0;
                j++;
            }
        }

        return snail;
    }
}