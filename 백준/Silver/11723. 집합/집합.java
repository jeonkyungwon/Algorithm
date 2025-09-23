import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int M = Integer.parseInt(br.readLine());
    	
    	int S = 0;
    	int All = (1 << 21) - 2;
    	StringBuilder sb = new StringBuilder();
    	
    	for (int i = 0; i < M; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		String cmd = st.nextToken();
    		
    		switch (cmd) {
	    		case "add": {
	    			int x = Integer.parseInt(st.nextToken());
	    			S |= (1 << x);
	    			break;
	    		}
	    		case "remove": {
	    			int x = Integer.parseInt(st.nextToken());
	    			S &= ~(1 << x);
	    			break;
	    		}
	    		case "check": {
	    			int x = Integer.parseInt(st.nextToken());
	    			sb.append((S & (1 << x)) != 0 ? 1 : 0).append('\n');
	    			break;
	    		}
	    		case "toggle": {
	    			int x = Integer.parseInt(st.nextToken());
	    			S  ^= (1 << x);
	    			break;
	    		}
	    		case "all": {
	    			S = All;
	    			break;
	    		}
	    		case "empty": {
	    			S = 0;
	    			break;
	    		}
    		}    		
    	}
    	
    	System.out.println(sb.toString());
    }
}