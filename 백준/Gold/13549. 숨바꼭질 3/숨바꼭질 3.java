import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, K;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        System.out.println(bfs(N, K));
    }
    
    static int bfs (int start, int target) {
    	if (start >= target) return start - target;
    	
    	int[] dist = new int[100001];
    	Arrays.fill(dist, -1);
    	
    	Queue<Integer> q = new ArrayDeque<>();
    	dist[start] = 0;
    	q.offer(start);
    	
    	while (!q.isEmpty()) {
    		int x = q.poll();
    		int[] nexts = {2 * x, x - 1, x + 1};
    		
    		if (x == target) return dist[x];
    		
    		for (int nx : nexts) {
    			if (nx < 0 || nx > 100000) continue;
    			if (dist[nx] != -1) continue;
    			if (nx == 2 * x) dist[nx] = dist[x];
    			else dist[nx] = dist[x] + 1;
    			q.offer(nx);
    		}
    	}
    	
    	return -1;
    }
}