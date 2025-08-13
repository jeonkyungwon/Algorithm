import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static List<List<Integer>> friends = new ArrayList<>();
	static boolean[] visited;
	static boolean found = false;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        for (int n = 0; n < N; n++) {
        	friends.add(new ArrayList<>());
        }
        
        for (int m = 0; m < M; m++) {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	
        	friends.get(a).add(b);
        	friends.get(b).add(a);        	
        }
        
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
        	if (!visited[i]) {
        		dfs(i, 0);
        		if (found) break;
        	}
        }
        
        System.out.println(found ? 1: 0);
    }
    
    static void dfs(int node, int depth) {
    	if (depth == 4) {
    		found = true;
    		return;
    	}
    	
    	visited[node] = true;
    	
    	for (int next : friends.get(node)) {
    		if (!visited[next]) {
    			dfs(next, depth + 1);
    			if (found) {
    				visited[node] = false;
    				return;
    			}
    		}
    	}
    	
    	visited[node] = false;
    }
}