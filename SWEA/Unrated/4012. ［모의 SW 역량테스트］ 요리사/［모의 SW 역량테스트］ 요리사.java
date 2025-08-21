import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int T, N, minDiff;
    static int[][] synergy;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            synergy = new int[N][N];
            visited = new boolean[N];
            minDiff = Integer.MAX_VALUE;

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    synergy[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            combi(0, 0);
            System.out.println("#" + t + " " + minDiff);
        }
    }

    static void combi(int idx, int cnt) {
        if (cnt == N / 2) {
            calcDiff();
            return;
        }
        if (idx >= N) return;

        visited[idx] = true;
        combi(idx + 1, cnt + 1);

        visited[idx] = false;
        combi(idx + 1, cnt);
    }

    static void calcDiff() {
        int aSum = 0, bSum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (visited[i] && visited[j]) {
                    aSum += synergy[i][j] + synergy[j][i];
                } else if (!visited[i] && !visited[j]) {
                    bSum += synergy[i][j] + synergy[j][i];
                }
            }
        }
        minDiff = Math.min(minDiff, Math.abs(aSum - bSum));
    }
}