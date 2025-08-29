import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    
	static int N, x;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < N; i++) {
        	x = Integer.parseInt(br.readLine());
        	if (x == 0) {
        		if (!pq.isEmpty()) System.out.println(pq.poll());
        		else System.out.println(0);
        	}
        	else {
        		pq.add(x);
        	}
        }  
    }
}