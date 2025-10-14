import java.io.*;
import java.util.*;

public class Main {
	
	static String vowels = "aeiou";
	
    public static void main(String[] args) throws IOException {        
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	while (true) {
    		String line = br.readLine();
    		if (line.equals("end")) {
    			break;
    		}
    		
    		boolean check = true;
    		int v = 0, c = 0, vCnt = 0;
    		for (int i = 0; i < line.length(); i++) {
    			char ch = line.charAt(i);
    			
    			if (ch != 'e' && ch != 'o' && i > 0) {
    				if (ch == line.charAt(i - 1)) {
    					check = false;
    					break;
    				}
    			}
    			
    			if (vowels.contains(String.valueOf(ch))) {
    				vCnt++;
    				v++;
    				c = 0;
    			} else {
    				c++;
    				v = 0;
    			}
    			
    			if (v == 3 || c == 3) {
					check = false;
    				break;
    			}
    		}
    		
    		if (!check) {
				System.out.println("<" + line + "> is not acceptable.");
    		} else {
	    		if (vCnt == 0) {
					System.out.println("<" + line + "> is not acceptable.");
	    		} else {
					System.out.println("<" + line + "> is acceptable.");
	    		}
    		}
    	}	
    }
}