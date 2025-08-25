import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, S;
    static int[] nums;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);

        if (S == 0) count--;

        System.out.println(count);
    }

    static void dfs(int idx, int sum) {
        if (idx == N) {
            if (sum == S) count++;
            return;
        }

        dfs(idx + 1, sum + nums[idx]);

        dfs(idx + 1, sum);
    }
}