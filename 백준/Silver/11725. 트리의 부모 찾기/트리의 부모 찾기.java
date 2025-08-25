import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N;
    static List<List<Integer>> graph = new ArrayList<>();
	static int[] visited;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int n = 0; n <= N; n++) {
    		graph.add(new ArrayList<>());
    	}
        
        for (int n = 0; n < N - 1; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	
        	graph.get(a).add(b);
        	graph.get(b).add(a);
        }
        
        visited = new int[N + 1];
        bfs();
        
        for (int i = 2; i <= N; i++) {
            System.out.println(visited[i]);
        }
    }
    
    static void bfs() {
        Queue<Integer> q = new ArrayDeque<>();
        visited[1] = 1;
        q.offer(1);

        while (!q.isEmpty()) {
        	int v = q.poll();
        	
        	for (int next : graph.get(v)) {
        		if (visited[next] == 0) {
        			visited[next] = v;
        			q.offer(next);
        		}
        	}
        }
    }
}