import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, i, j;
	static int[] books;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		books = new int[N];
		for (int i = 0; i < N; i++) {
			books[i] = i + 1;
		}
		
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			i = Integer.parseInt(st.nextToken()) - 1;
			j = Integer.parseInt(st.nextToken()) - 1;
			
			for (int k = 0; k <= (j - i) / 2; k++) {
				int tmp = books[i + k];
				books[i + k] = books[j - k];
				books[j - k] = tmp;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(books[i]).append(" ");
		}
		
		System.out.println(sb);
	}
}