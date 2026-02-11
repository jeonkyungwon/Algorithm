import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static boolean[] visited;
    static int[] nums, p;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        visited = new boolean[N];

        p = new int[N];
        for (int n = 1; n <= N; n++) p[n - 1] = n;

        perm(0);
    }

    static void perm(int cnt) {
        if (cnt == N) {
            for (int n = 0; n < N; n++) System.out.print(nums[n] + " ");
            System.out.println();
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            nums[cnt] = p[i];
            perm(cnt + 1);
            visited[i] = false;
        }
    }
}