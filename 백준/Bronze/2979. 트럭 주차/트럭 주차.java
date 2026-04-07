import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] time = new int[100];
        int m = 0;
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            m = Math.max(m, e);
            for (int j = s; j < e; j++) {
                time[j] += 1;
            }
        }

        int sum = 0;
        for (int i = 1; i < m; i++) {
            if (time[i] == 1) sum += A;
            else if (time[i] == 2) sum += B * 2;
            else if (time[i] == 3) sum += C * 3;
        }

        System.out.println(sum);
    }
}