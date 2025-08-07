import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static List<List<Integer>> com = new ArrayList<>();
	static boolean[] visited;
	static int cnt = 0;
	
    public static void main(String[] args) throws IOException {        
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	int tag = Integer.parseInt(br.readLine());
    	
    	for (int n = 0; n <= N; n++) {
    		com.add(new ArrayList<>());
    	}
    	
    	for (int t = 0; t < tag; t++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	
        	com.get(a).add(b);
        	com.get(b).add(a);
    	}
    	
    	visited = new boolean[N + 1];
    	dfs(1);
    	System.out.println(cnt);
    }
    
    static void dfs(int node) {
    	visited[node] = true;
    	
    	for (int next : com.get(node)) {
    		if (!visited[next]) {
    			cnt++;
    			dfs(next);
    		}
    	}
    }
}