import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] p, nums;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new int[M];
        p = new int[N];

        perm(0);
        System.out.println(sb);
    }

    static void perm(int cnt) {
        if (cnt == M) {
            for (int i = 0; i < M; i++) {
                sb.append(p[i]).append(" ");
            }
            sb.append("\n");

            return;
        }

        for (int n = 1; n <= N; n++) {
            p[cnt] = n;
            perm(cnt + 1);
        }
    }
}