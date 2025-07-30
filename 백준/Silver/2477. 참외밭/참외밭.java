import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int d, b, s, dir;
	static int[] len;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int K = Integer.parseInt(br.readLine());
		int maxLen = 0, idx = 0;
		int answer;

		len = new int[6];
		for (int i = 0; i < 6; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			d = Integer.parseInt(st.nextToken());
			len[i] = Integer.parseInt(st.nextToken());
			if (len[i] > maxLen) {
				maxLen = len[i];
				idx = i;
			}
		}
		
		int left = (idx + 5) % 6;
		int right = (idx + 1) % 6;

		if (len[left] > len[right]) {
			b = left;
			s = right;
			dir = 1;
		} else {
			b = right;
			s = left;
			dir = -1;
		}

		int tot = len[idx] * len[b];
		int empty = len[(s + dir * 1 + 6) % 6] * len[(s + dir * 2 + 6) % 6];
		
		System.out.println((tot - empty) * K);
	}
}