import java.io.*;
import java.util.*;

public class Main {

    static int N, M, R, num;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            for (int m = 0; m < M; m++) {
                arr[n][m] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < R; i++) {
            num = Integer.parseInt(st.nextToken());

            if (num == 1) firstCal();
            else if (num == 2) secondCal();
            else if (num == 3) {
                arr = thirdCal();
                int tmp = N;
                N = M;
                M = tmp;
            } else if (num == 4) {
                arr = fourthCal();
                int tmp = N;
                N = M;
                M = tmp;
            }
            else if (num == 5) arr = fifthCal();
            else if (num == 6) arr = sixthCal();
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        
        System.out.println(sb);
    }

    static void firstCal() {
        int tmp;

        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < M; j++) {
                tmp = arr[i][j];
                arr[i][j] = arr[N - 1 - i][j];
                arr[N - 1 - i][j] = tmp;
            }
        }
    }

    static void secondCal() {
        int tmp;

        for (int i = 0; i < M / 2; i++) {
            for (int j = 0; j < N; j++) {
                tmp = arr[j][i];
                arr[j][i] = arr[j][M - 1 - i];
                arr[j][M - 1 - i] = tmp;
            }
        }
    }

    static int[][] thirdCal() {
        int[][] A = new int[M][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                A[j][N - 1 - i] = arr[i][j];
            }
        }

        return A;
    }

    static int[][] fourthCal() {
        int[][] A = new int[M][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                A[M - 1 - j][i] = arr[i][j];
            }
        }

        return A;
    }

    static int[][] fifthCal() {
        int[][] A = new int[N][M];

        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < M / 2; j++) {
                A[i][j] = arr[N / 2 + i][j];
                A[i][M / 2 + j] = arr[i][j];
                A[N / 2 + i][M / 2 + j] = arr[i][M / 2 + j];
                A[N / 2 + i][j] = arr[N / 2 + i][M / 2 + j];
            }
        }

        return A;
    }

    static int[][] sixthCal() {
        int[][] A = new int[N][M];

        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < M / 2; j++) {
                A[i][j] = arr[i][M / 2 + j];
                A[i][M / 2 + j] = arr[N / 2 + i][M / 2 + j];
                A[N / 2 + i][M / 2 + j] = arr[N / 2 + i][j];
                A[N / 2 + i][j] = arr[i][j];
            }
        }

        return A;
    }
}