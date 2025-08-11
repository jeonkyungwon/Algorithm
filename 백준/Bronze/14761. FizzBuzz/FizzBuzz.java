import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {        
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int X = Integer.parseInt(st.nextToken());
    	int Y = Integer.parseInt(st.nextToken());
    	int N = Integer.parseInt(st.nextToken());
    	
    	for (int i = 1; i <= N; i++) {
    		if (i % X == 0 && i % Y == 0) {
    			System.out.println("FizzBuzz");
    		} else if (i % X == 0) {
    			System.out.println("Fizz");
    		} else if (i % Y == 0) {
    			System.out.println("Buzz");
    		} else {
    			System.out.println(i);
    		}
    	}
    }
}