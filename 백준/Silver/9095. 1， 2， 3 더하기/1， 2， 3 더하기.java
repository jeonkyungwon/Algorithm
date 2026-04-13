import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            n = Integer.parseInt(br.readLine());
            dp = new int[n + 1];

            recursive();

            System.out.println(dp[n]);
        }
    }

    static void recursive() {
        dp[1] = 1;
        if (n == 1) return;
        dp[2] = 2;
        if (n == 2) return;
        dp[3] = 4;

        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
        }
    }
}