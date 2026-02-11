import java.io.*;
import java.util.*;

public class Main {

    static int N, cmd;
    static long k;
    static int[] p, target, nums;
    static boolean[] visited;
    static long[] fact;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        p = new int[N];
        for (int i = 0; i < N; i++) p[i] = i + 1;

        target = new int[N];
        nums = new int[N];
        visited = new boolean[N + 1];

        fact = new long[N + 1];
        fact[0] = 1;
        for (int i = 1; i <= N; i++) fact[i] = fact[i - 1] * i;

        StringTokenizer st = new StringTokenizer(br.readLine());
        cmd = Integer.parseInt(st.nextToken());

        if (cmd == 1) {
            k = Long.parseLong(st.nextToken());
            solveCmd1();
        } else {
            for (int i = 0; i < N; i++) target[i] = Integer.parseInt(st.nextToken());
            solveCmd2();
        }
    }

    static void solveCmd1() {
        long kk = k - 1;

        for (int pos = 0; pos < N; pos++) {
            long block = fact[N - 1 - pos];
            long idx = kk / block;
            kk %= block;

            int pick = pickIdxUnused(idx);
            nums[pos] = pick;
            visited[pick] = true;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(nums[i]).append(' ');
        }
        System.out.print(sb.toString().trim());
    }

    static void solveCmd2() {
        long rank = 0;

        for (int pos = 0; pos < N; pos++) {
            int x = target[pos];

            long smallerUnused = 0;
            for (int v = 1; v < x; v++) {
                if (!visited[v]) smallerUnused++;
            }

            rank += smallerUnused * fact[N - 1 - pos];
            visited[x] = true;
        }

        System.out.println(rank + 1);
    }

    static int pickIdxUnused(long idx) {
        long cnt = 0;
        for (int v = 1; v <= N; v++) {
            if (visited[v]) continue;
            if (cnt == idx) return v;
            cnt++;
        }
        return -1;
    }
}