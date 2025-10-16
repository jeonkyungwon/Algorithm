import java.io.*;
import java.util.*;

public class Main {
	
	static Set<String> names = new HashSet<String>();
	static HashMap<String, Integer> games = new HashMap<>();
	static {
		games.put("Y", 2);
		games.put("F", 3);
		games.put("O", 4);
	}
	
    public static void main(String[] args) throws IOException {        
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int N = Integer.parseInt(st.nextToken());
    	String K = st.nextToken();
    	
    	int play = games.get(K);
    	for (int i = 0; i < N; i++ ) {
    		String name = br.readLine();
    		names.add(name);
    	}
    	
    	int answer = names.size() / (play - 1);
    	System.out.println(answer);
    }
}