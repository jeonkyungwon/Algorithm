import java.io.*;
import java.util.*;

public class Main {

    static int r, c;
    static long cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int size = 1 << N;

        divide(0, 0, size);

        System.out.println(cnt);
    }

    static void divide(int x, int y, int s) {
        if (s == 1) return;

        int half = s / 2;
        long area = (long) half * half;

        if (r < x + half && c < y + half) {
            divide(x, y, half);
        }
        else if (r < x + half && c >= y + half) {
            cnt += area;
            divide(x, y + half, half);
        }
        else if (r >= x + half && c < y + half) {
            cnt += 2 * area;
            divide(x + half, y, half);
        }
        else {
            cnt += 3 * area;
            divide(x + half, y + half, half);
        }
    }
}