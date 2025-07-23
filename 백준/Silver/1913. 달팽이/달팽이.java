import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, L;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int[] location = new int[2];
	
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		L = Integer.parseInt(br.readLine());
		int [][] snail = generateSnail();
		
		printSnail(snail);
	}
	
	static int[][] generateSnail() {
		int [][] snail = new int[N][N];
		int x = N / 2, y = N / 2;
		int num = 1, d = 0;
		int cnt = 0, step = 1, s = 0;
		
		while (num <= N * N) {
			snail[x][y] = num;
			if (num == L) {
				location[0] = x + 1;
				location[1] = y + 1;
			}
			
			x += dx[d];
			y += dy[d];
			s += 1;
			num += 1;
			
			if (s == step) {
				d = (d + 1) % 4;
				s = 0;
				cnt += 1;
			}
			
			if (cnt == 2 && step < N - 1) {
				step += 1;
				cnt = 0;
			}
		}
		
		return snail;
	}
	
	static void printSnail(int[][] snail) {
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(snail[i][j]).append(" ");
			}
			sb.append("\n");
		}		
		System.out.print(sb);
		System.out.println(location[0] + " " + location[1]);
	}
}