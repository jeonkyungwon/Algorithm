import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {  
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int N = Integer.parseInt(st.nextToken());
    	int K = Integer.parseInt(st.nextToken());
    	
    	String arr = br.readLine();

    	boolean[] visited = new boolean[N];
    	int cnt = 0;
    	for (int n = 0; n < N; n++) {
    		char ch = arr.charAt(n);
    		if (ch == 'H') continue;
    		
    		int s = n - K >= 0 ? n - K : 0;
    		int e = n + K < N ? n + K : N - 1;
    		for (int i = s; i <= e; i++) {
    			if (arr.charAt(i) == 'H' && !visited[i]) {
    				visited[i] = true;
    				cnt++;
    				break;
    			}
    		}
    	}
    	
    	System.out.println(cnt);
    }
}