import java.io.*;
import java.util.*;

public class Main {

	static int[][] physical;
	static int N;
	
    public static void main(String[] args) throws IOException {        
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	N = Integer.parseInt(br.readLine());
    	
    	physical = new int[N][2];
    	for (int i = 0; i < N; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		
    		physical[i][0] = Integer.parseInt(st.nextToken());
    		physical[i][1] = Integer.parseInt(st.nextToken());
    	}
    	
    	StringBuilder sb = new StringBuilder();
    	for (int i = 0; i < N; i++) {
    		sb.append(rankCheck(i)).append(" ");
    	}
    	
    	System.out.println(sb);
    }
    
    static int rankCheck(int n) {
    	int rank = 0;
    	
    	for (int i = 0; i < N; i++) {
    		if (i == n) continue;
    		if (physical[i][0] > physical[n][0] && physical[i][1] > physical[n][1]) rank++;
    	}
    	
    	return rank + 1;
    }
}