import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] paper;
    static int white = 0, blue = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        paper = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divide(0, 0, N);

        System.out.println(white + "\n" + blue);
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
            if (color == 0) white++;
            else blue++;
            
            return;
        }

        int half = size / 2;
        divide(r, c, half);
        divide(r, c + half, half);
        divide(r + half, c, half);
        divide(r + half, c + half, half);
    }
}