import java.io.*;
import java.util.*;

public class Main {

    static List<Integer> budget = new ArrayList<>();
    
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++) {
        	budget.add(Integer.parseInt(st.nextToken()));
        }
        
        int M = Integer.parseInt(br.readLine());
        
        int s = 1, e = Collections.max(budget);
        int answer = 0;
        while (s <= e) {
        	int mid = (s + e) / 2;
        	int sum = 0;
        	for (int b : budget) {
        		if (b <= mid) sum += b;
        		else sum += mid;
        	}
        	
        	if (sum > M) e = mid - 1;
        	else if (sum < M) {
        		s = mid + 1;
        		answer = mid;
        	}
        	else {
        		answer = mid;
        		break;
        	}
        }
        
        System.out.println(answer);
    }
}