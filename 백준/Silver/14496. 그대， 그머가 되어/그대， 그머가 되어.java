import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int a, b, N, M;
	static List<List<Integer>> graph = new ArrayList<>();
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        for (int n = 0; n <= N; n++) {
        	graph.add(new ArrayList<>());
        }
                
        for (int m = 0; m < M; m++) {
        	st = new StringTokenizer(br.readLine());
        	int x = Integer.parseInt(st.nextToken());
        	int y = Integer.parseInt(st.nextToken());
        	
        	graph.get(x).add(y);
        	graph.get(y).add(x);
        }
        
        System.out.println(bfs(a, b));
    }
    
    static int bfs(int start, int target) {
        if (start == target) return 0;

        int[] dist = new int[N + 1];
        Arrays.fill(dist, -1);

        Queue<Integer> q = new ArrayDeque<>();
        dist[start] = 0;
        q.offer(start);

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : graph.get(cur)) {
                if (dist[next] != -1) continue;
                dist[next] = dist[cur] + 1;
                if (next == target) return dist[next];
                q.offer(next);
            }
        }

        return -1;
    }
}