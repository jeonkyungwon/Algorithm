import java.io.*;
import java.util.*;

public class Main {

	static Queue<Integer> q = new ArrayDeque<>();
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        for (int n = 1; n <= N; n++) {
        	q.offer(n);
        }
        
        while (q.size() > 1) {
        	q.poll();
        	if (q.size() == 1) break;
        	q.add(q.poll());
        }
        
        System.out.println(q.peek());
    }
}