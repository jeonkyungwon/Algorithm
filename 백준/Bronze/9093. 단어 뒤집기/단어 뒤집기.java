import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {        
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int T = Integer.parseInt(br.readLine());
    	
    	StringBuilder result = new StringBuilder();
    	for (int t = 0; t < T; t++) {
    		String line = br.readLine();
    		String[] words = line.split(" ");
    		
    		for (String word : words) {
    			StringBuilder sb = new StringBuilder(word);
    			result.append(sb.reverse()).append(" ");
    		}
    		result.append("\n");
    	}
    	System.out.println(result);
    }
}