import java.io.*;
import java.util.*;

public class Main {

	static int[][] medal;
	static int rank = 0;
	
    public static void main(String[] args) throws IOException {        
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int N = Integer.parseInt(st.nextToken());
    	int K = Integer.parseInt(st.nextToken());
    	
    	medal = new int[N + 1][3];
    	
    	for (int i = 0; i < N; i++) {
    		st = new StringTokenizer(br.readLine());
    		int c = Integer.parseInt(st.nextToken());
    		
    		for (int j = 0; j < 3; j++) {
    			medal[c][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	int[] target = medal[K];
    	
    	for (int i = 1; i <= N; i++) {
    		if (i != K) {
    			rankCheck(target, medal[i]);
    		}
    	}
    	
    	System.out.println(rank + 1);
    }
    
    static void rankCheck(int[] target, int[] medal) {
    	if (target[0] < medal[0]) rank++;
    	else if (target[0] == medal[0]) {
    		if (target[1] < medal[1]) rank++;
    		else if (target[1] == medal[1]) {
    			if (target[2] < medal[2]) rank++;
    		}
    	}
    }
}