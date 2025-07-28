import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] nums, prefix;
	
    public static void main(String[] args) throws IOException {        
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	
    	nums = new int[N];
    	prefix = new int[N];
    	
    	st = new StringTokenizer(br.readLine());
    	for (int n = 0; n < N; n++) {
    		nums[n] = Integer.parseInt(st.nextToken());
    	}
    	
    	prefix[0] = nums[0];
    	for (int n = 1; n < N; n++) {
    	    prefix[n] = prefix[n - 1] + nums[n];
    	}
    	
    	for (int m = 0; m < M; m++) {
        	st = new StringTokenizer(br.readLine());

    		int i = Integer.parseInt(st.nextToken()) - 1;
    		int j = Integer.parseInt(st.nextToken()) - 1;
    		
            int sum = i == 0 ? prefix[j] : prefix[j] - prefix[i - 1];
            System.out.println(sum);
    	}
    }
}