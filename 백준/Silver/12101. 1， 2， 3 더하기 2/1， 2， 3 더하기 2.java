import java.io.*;
import java.util.*;

public class Main {

    static int n, k;
    static int[] dp;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        dp = new int[n + 1];
        if (n >= 1) dp[1] = 1;
        if (n >= 2) dp[2] = 2;
        if (n >= 3) dp[3] = 4;

        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        if (k > dp[n]) {
            System.out.println(-1);
            return;
        }

        recursive();
        System.out.println(sb);
    }

    static void recursive() {
        if (n == 1) {
            sb.append(1);
            return;
        }

        if (n == 2) {
            if (k == 1) sb.append("1+1");
            else sb.append(2);
            return;
        }

        if (n == 3) {
            if (k == 1) sb.append("1+1+1");
            else if (k == 2) sb.append("1+2");
            else if (k == 3) sb.append("2+1");
            else sb.append(3);
            return;
        }

        if (k <= dp[n - 1]) {
            sb.append(1).append('+');
            n -= 1;
            recursive();
        }

        else if (k <= dp[n - 1] + dp[n - 2]) {
            sb.append(2).append('+');
            k -= dp[n - 1];
            n -= 2;
            recursive();
        }
        else {
            sb.append(3).append('+');
            k -= dp[n - 1]  +dp[n - 2];
            n -= 3;
            recursive();
        }
    }
}