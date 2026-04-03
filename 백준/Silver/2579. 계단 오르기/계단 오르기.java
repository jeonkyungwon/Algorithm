import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] stairs, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        stairs = new int[N + 1];
        for (int n = 1; n <= N; n++) {
            stairs[n] = Integer.parseInt(br.readLine());
        }

        if (N == 1) {
            System.out.println(stairs[1]);
            return;
        }
        if (N == 2) {
            System.out.println(stairs[1] + stairs[2]);
            return;
        }

        dp = new int[N + 1];
        dp[1] = stairs[1];
        dp[2] = stairs[1] + stairs[2];
        dp[3] = Math.max(stairs[1], stairs[2]) + stairs[3];

        for (int n = 4; n <= N; n++) {
            dp[n] = Math.max(dp[n - 2], dp[n - 3] + stairs[n - 1]) + stairs[n];
        }

        System.out.println(dp[N]);
    }
}