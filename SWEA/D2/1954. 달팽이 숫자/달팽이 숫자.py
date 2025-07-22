import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Solution {
    static int T, N;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	T = Integer.parseInt(br.readLine());
    	
    	for (int t = 1; t <= T; t++) {
    		N = Integer.parseInt(br.readLine());
    		int[][] snail = generateSnail();
    		
    		printSnail(snail, t);
    	}
    }
    
    static int[][] generateSnail() {
    	int[][] snail = new int[N][N];
    	int x = 0, y = 0, d = 0, num = 1;
    	
    	while (num <= N * N) {
    		snail[x][y] = num;
    		
    		int nx = x + dx[d];
    		int ny = y + dy[d];
    		
    		if (nx < 0 || ny < 0 || nx >=N || ny >= N || snail[nx][ny] != 0) {
    			d = (d + 1) % 4;
    			nx = x + dx[d];
    			ny = y + dy[d];
    		}
    		
    		x = nx;
    		y = ny;
    		num++;
    	}
    	
    	return snail;
    }
    
    static void printSnail(int[][] snail, int t) {
    	StringBuilder sb = new StringBuilder();
    	sb.append("#").append(t).append("\n");
    	
    	for (int i = 0; i < N; i++) {
    		for (int j = 0; j < N; j++) {
    			sb.append(snail[i][j]).append(" ");
    		}
    		sb.append("\n");
    	}
    	
    	System.out.print(sb);
    }
}