import java.io.*;
import java.nio.Buffer;
import java.util.*;

public class Main {

    static int[][] paper;
    static int minus = 0, plus = 0, zero = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        paper = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divide(0, 0, N);

        System.out.println(minus + "\n" + zero + "\n" + plus);
    }

    static void divide(int r, int c, int size) {
        int color = paper[r][c];
        boolean same = true;

        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (paper[i][j] != color) {
                    same = false;
                    break;
                }
            }
            if (!same) break;
        }

        if (same) {
            if (color == -1) minus++;
            else if (color == 0) zero++;
            else plus++;

            return;
        }

        int newSize = size / 3;

        for (int dr = 0; dr < 3; dr++) {
            for (int dc = 0; dc < 3; dc++) {
                divide(r + dr * newSize, c + dc * newSize, newSize);
            }
        }
    }
}