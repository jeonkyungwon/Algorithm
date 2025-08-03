import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] nums, stack;
    static int size;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        int num = 1, c = 0;
        stack = new int[n];
        StringBuilder sb = new StringBuilder();
        while (num <= n) {
            stack[size++] = num++;
            sb.append("+\n");

            while (size > 0 && nums[c] == stack[size - 1]) {
                size--;
                sb.append("-\n");
                c++;
            }
        }

        if (size == 0) System.out.print(sb);
        else System.out.print("NO");
    }
}