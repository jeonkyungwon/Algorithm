import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static List<List<Integer>> graph = new ArrayList<>();
	static boolean[] visited;
	static int cnt = 0;
	
    public static void main(String[] args) throws IOException {        
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	
    	for (int i = 0; i <= N; i++ ) {
    		graph.add(new ArrayList<>());
    	}
    	
    	for (int m = 0; m < M; m++) {
    		st = new StringTokenizer(br.readLine());
    		int u = Integer.parseInt(st.nextToken());
    		int v = Integer.parseInt(st.nextToken());
    		
    		graph.get(u).add(v);
    		graph.get(v).add(u);
    	}
    	
    	visited = new boolean[N + 1];
    	for (int i = 1; i <= N; i++) {
    		if (!visited[i]) {
    			cnt++;
    			dfs(i);
    		}
    	}
    	
    	System.out.println(cnt);
    }
    
    static void dfs(int node) {
    	visited[node] = true;
    	
    	for (int next : graph.get(node)) {
    		if (!visited[next]) {
        		dfs(next);	
    		}
    	}
    }
}