import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int F, S, G, U, D;
	
    public static void main(String[] args) throws IOException {        
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	F = Integer.parseInt(st.nextToken());
    	S = Integer.parseInt(st.nextToken());
    	G = Integer.parseInt(st.nextToken());
    	U = Integer.parseInt(st.nextToken());
    	D = Integer.parseInt(st.nextToken());
    	
    	int answer = bfs(S, G);
        if (answer == -1) System.out.println("use the stairs");
    	else System.out.println(answer);
    }
    
    static int bfs(int start, int arrive) {
    	if (start == arrive) return 0;
    	
    	int[] dist = new int[F + 1];
    	Arrays.fill(dist, -1);
    	
    	Queue<Integer> q = new ArrayDeque<>();
    	dist[start] = 0;
    	q.offer(start);
    	
    	while (!q.isEmpty()) {
    		int x = q.poll();  		
    		if (x == arrive) return dist[x];
    		
    		int[] dir = {x + U, x - D};
    		for (int nx : dir) {
    			if (nx < 1 || nx > F) continue;
    			if (dist[nx] != -1) continue;
    			dist[nx] = dist[x] + 1;
    			q.offer(nx);
    		}
    		
    	}
    	
    	return -1;
    }
}