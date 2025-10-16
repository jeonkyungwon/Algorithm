import java.io.*;
import java.util.*;

public class Main {
	
	static int[] switches;
	
	public static void main(String[] args) throws IOException {        
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int N = Integer.parseInt(br.readLine());
    	switches = new int[N + 1];
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	for (int n = 1; n <= N; n++) {
    		switches[n] = Integer.parseInt(st.nextToken());
    	}

    	int M = Integer.parseInt(br.readLine());
    	for (int m = 0; m < M; m++ ) {
    		st = new StringTokenizer(br.readLine());
    		int s = Integer.parseInt(st.nextToken());
    		int c = Integer.parseInt(st.nextToken());
    		
    		if (s == 1) {
    			for (int i = 1; c * i <= N; i++) {
    				if (switches[c * i] == 0) switches[c * i] = 1;
    				else switches[c * i] = 0;
    			}
    		} else {
    			if (switches[c] == 0) switches[c] = 1;
				else switches[c] = 0;    			

    			int i = 1;
    			while (c - i > 0 && c + i <= N) {
    				if (switches[c - i] == switches[c + i]) {
    					if (switches[c - i] == 0) {
    						switches[c - i] = 1;
    						switches[c + i] = 1;
    					}
        				else {
        					switches[c - i] = 0;
    						switches[c + i] = 0;
        				}
    				} else {
    					break;
    				}
    				
    				i++;
    			}
    		}
    	}
    	
    	StringBuilder sb = new StringBuilder();
    	for (int n = 1; n <= N; n++) {
    		sb.append(switches[n]).append(" ");
    		if (n % 20 == 0) sb.append("\n");
    	}
    	
    	System.out.println(sb.toString());
    }
}