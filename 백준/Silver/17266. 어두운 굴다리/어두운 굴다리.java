import java.io.*;
import java.util.*;

public class Main {

	static int[] lamps;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        
        lamps = new int[M];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int m = 0; m < M; m++) {
        	lamps[m] = Integer.parseInt(st.nextToken());
        }
        
        int r = Math.max(lamps[0], N - lamps[M - 1]);
        for (int i = 1; i < M; i++) {
        	r = Math.max(r, (lamps[i] - lamps[i - 1] + 1) / 2);
        }
        
        System.out.println(r);
    }
}