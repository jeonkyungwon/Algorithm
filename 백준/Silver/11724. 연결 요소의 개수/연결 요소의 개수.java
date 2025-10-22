import java.io.*;
import java.util.*;

public class Main {

	static List<List<Integer>> graph = new ArrayList<>();
	static boolean[] visited;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        for (int n = 0; n <= N; n++) {
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
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
        	if (!visited[i]) {
        		dfs(i);
        		cnt++;
        	}
        }
        
        System.out.println(cnt);
    }
    
    static void dfs(int node) {
    	visited[node] = true;
    	
    	for (int next : graph.get(node)) {
    		if (!visited[next]) {
    			visited[next] = true;
    			dfs(next);
    		}
    	}
    }
}