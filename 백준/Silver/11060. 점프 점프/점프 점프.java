import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int[] maze;
	static int[] dist;
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	N = Integer.parseInt(br.readLine());
    	
    	maze = new int[N];
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	for (int n = 0; n < N; n++) maze[n] = Integer.parseInt(st.nextToken());
    	
    	dist = new int[N];
    	Arrays.fill(dist, -1);
    	
    	bfs();
    	
    	System.out.println(dist[N - 1]);
    }
    	
    static void bfs() {
    	Deque<Integer> q = new ArrayDeque<>();
    	q.offer(0);
    	dist[0] = 0;
    	
    	while(!q.isEmpty()) {
    		int cur = q.poll();
    		
    		for (int i = 1; i <= maze[cur]; i++) {
    			int next = cur + i;
    			if (next >= N) break;
    			
    			if (dist[next] == -1) {
    				dist[next] = dist[cur] + 1;
    				q.offer(next);
    			}
    		}
    	}
    }    
}