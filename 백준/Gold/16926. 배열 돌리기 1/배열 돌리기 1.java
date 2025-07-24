import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, R;
	static int[][] A; 
	
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		A = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		rotateArr();
		
		StringBuilder sb = new StringBuilder();
        for (int[] row : A) {
            for (int num : row) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
	}
	
	static void rotateArr() {
		int layers = Math.min(N, M) / 2;
		
		for (int r = 0; r < R; r++) {
			for (int layer = 0; layer < layers; layer++) {
				int top = layer;
				int left = layer;
				int bottom = N - 1 - layer;
				int right = M - 1 - layer;
				int tmp = A[top][left];
				
				for (int i = left; i < right; i++) {
					A[top][i] = A[top][i + 1];
				}
				for (int i = top; i < bottom; i++) {
	                A[i][right] = A[i + 1][right];
	            }

	            for (int i = right; i > left; i--) {
	                A[bottom][i] = A[bottom][i - 1];
	            }

	            for (int i = bottom; i > top; i--) {
	                A[i][left] = A[i - 1][left];
	            }

	            A[top + 1][left] = tmp;
			}
		}		
	}
	
}