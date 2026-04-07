import java.io.*;
import java.util.*;

public class Main {

    static int a, b, sum = 0;
    static int[] H;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        H = new int[9];
        for (int i = 0; i < 9; i++) {
            H[i] = Integer.parseInt(br.readLine());
            sum += H[i];
        }

        Arrays.sort(H);
        find();

        for (int i = 0; i < 9; i++) {
            if (H[i] == a || H[i] == b) continue;
            System.out.println(H[i]);
        }
    }

    static void find() {
        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (sum - H[i] - H[j] == 100) {
                    a = H[i];
                    b = H[j];
                    return;
                }
            }
        }
    }
}