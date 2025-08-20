import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, minDiff = 1_000_000_000;
	static int[] S;
	static int[] B;
		
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		S = new int[N];
		B = new int[N];
		
		for (int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			S[n] = Integer.parseInt(st.nextToken());
			B[n] = Integer.parseInt(st.nextToken());	
		}

		combi(0, 1, 0, 0);
		
		System.out.println(minDiff);
	}	
	
	static void combi(int start, int sour, int bitter, int cnt) {
		if (cnt >= 1) {
			int diff = Math.abs(sour - bitter);
			minDiff = Math.min(minDiff, diff);
		}
		
		if (start == N) return;
		
		for (int i = start; i < N; i++) {
			combi(i + 1, sour * S[i], bitter + B[i], cnt + 1);
		}
	}
}