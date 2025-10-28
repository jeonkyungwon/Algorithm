import java.io.*;
import java.util.*;

public class Main {

    static List<Integer> visitor = new ArrayList<>();
    static List<Integer> prefix = new ArrayList<>();
    
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++ ) {
        	visitor.add(Integer.parseInt(st.nextToken()));
        }
        
        if (Collections.max(visitor) == 0) System.out.println("SAD");
        else {
        	int sum = 0;
        	for (int i = 0; i < N; i++) {
        		sum += visitor.get(i);
        		prefix.add(sum);
        	}
        	
        	int maxPrefix = prefix.get(X - 1), cnt = 1;
        	for (int i = X; i < N; i++) {
        		int p = prefix.get(i) - prefix.get(i - X);
        		if (p > maxPrefix) {
        			maxPrefix = p;
        			cnt = 1;
        		}
        		else if (p == maxPrefix) cnt++;
        	}
        	
        	System.out.println(maxPrefix + "\n" + cnt);
        }
    }
}