import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static long A, B;
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	A = Long.parseLong(st.nextToken());
    	B = Long.parseLong(st.nextToken());
    	
    	System.out.println(solution(A, B));
    }
    
    static long solution (long start, long target) {
    	int cnt = 1;
    	
    	if (start > target) return -1;
    	
    	while (target > start) {
    		if (target % 2 == 0) target /= 2;
    		else {
    			if (target % 10 == 1) target = (target - 1) / 10;
    			else return -1;
    		}
    		
    		cnt++;
    	}
    	
    	return (target == start) ? cnt : -1;
    }
}