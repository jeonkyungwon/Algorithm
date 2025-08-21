import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, minDiff;
	static int[][] stat;
	static boolean[] visited;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        stat = new int[N][N];
        visited = new boolean[N];
        minDiff = Integer.MAX_VALUE;
        
        for (int i = 0; i < N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	for (int j = 0; j < N; j++) {
        		stat[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        combi(0, 0);
        
        System.out.println(minDiff);
    }
    
    static void combi(int idx, int cnt) {
    	if (cnt == N / 2) {
    		calDiff();
    		return;
    	}

    	if (idx >= N) return;

    	visited[idx] = true;
    	combi(idx + 1, cnt + 1);
    	
    	visited[idx] = false;
    	combi(idx + 1, cnt);
    }
    
    static void calDiff() {
    	int start = 0, link = 0;
    	
    	for (int i = 0; i < N; i++) {
    		for(int j = i + 1; j < N; j++) {
    			if (visited[i] && visited[j]) {
    				start += stat[i][j] + stat[j][i];
    			} else if (!visited[i] && !visited[j]) {
    				link += stat[i][j] + stat[j][i];
    			}
    		}
    	}
    	
    	minDiff = Math.min(minDiff, Math.abs(start - link));
    }
}