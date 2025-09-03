import java.io.*;
import java.util.*;

public class Main {
	
	static int n, m, a, b, cnt = 0;
	static List<List<Integer>> relation = new ArrayList<>();
	static int[] dist;

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	n = Integer.parseInt(br.readLine());
    	m = Integer.parseInt(br.readLine());
    	
    	for (int i = 0; i <= n; i++) relation.add(new ArrayList<>());
    	
    	for (int i = 0; i < m; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		a = Integer.parseInt(st.nextToken());
    		b = Integer.parseInt(st.nextToken());
    		
    		relation.get(a).add(b);
    		relation.get(b).add(a);
    	}
    	
    	dist = new int[n + 1];
    	Arrays.fill(dist, -1);
    	
    	bfs();
    	
    	int cnt = 0;
    	for (int i = 2; i <= n; i++) {
    		if (dist[i] == 1 || dist[i] == 2) cnt++; 
    	}
    	
    	System.out.println(cnt);
    }
    
    static void bfs() {
    	Deque<Integer> dq = new ArrayDeque<>();
    	dist[1] = 0;
    	dq.offer(1);
    	
    	while (!dq.isEmpty()) {
    		int v = dq.poll();
    		
    		for (int next : relation.get(v)) {
    			if (dist[next] == -1) {
    				dist[next] = dist[v] + 1;
    				if (dist[next] < 2) dq.offer(next);
    			}
    		}
    	}
    }
}