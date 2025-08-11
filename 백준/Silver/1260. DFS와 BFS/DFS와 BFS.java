import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, V;
	static List<List<Integer>> graph = new ArrayList<>();
	static boolean[] visited;
	
    public static void main(String[] args) throws IOException {        
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	V = Integer.parseInt(st.nextToken());
    	
    	for (int n = 0; n <= N; n++) {
    		graph.add(new ArrayList<>());
    	}
    	
    	for (int m = 0; m < M; m++) {
    		st = new StringTokenizer(br.readLine());
    		int a = Integer.parseInt(st.nextToken());
    		int b = Integer.parseInt(st.nextToken());
    		
    		graph.get(a).add(b);
    		graph.get(b).add(a);
    	}
    	
    	for (int i = 1; i <= N; i++) {
    	    Collections.sort(graph.get(i));
    	}
    	
    	visited = new boolean[N + 1];
    	dfs(V);
        System.out.println();

        visited = new boolean[N + 1];
    	bfs(V);
    	
    }
    
    static void dfs(int node) {
    	visited[node] = true;
    	System.out.print(node + " ");
    	
    	for (int next : graph.get(node)) {
    		if (!visited[next]) {
    			dfs(next);
    		}
    	}
    }
    
    static void bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        visited[start] = true;
        q.offer(start);

        while (!q.isEmpty()) {
            int now = q.poll();
            System.out.print(now + " ");

            for (int next : graph.get(now)) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }
    }
}