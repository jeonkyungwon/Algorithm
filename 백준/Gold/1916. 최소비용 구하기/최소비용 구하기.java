import java.io.*;
import java.util.*;

public class Main {

	static int N, M, a, b, start, end, cost;
	static List<List<Integer>> graph;
	static int[][] costs;
	static int[] maxCost;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		costs = new int[N + 1][N + 1];
		for (int i = 0; i <= N; i++) {
			Arrays.fill(costs[i], Integer.MAX_VALUE);
		}
		graph = new ArrayList<>();
		maxCost = new int[N + 1];
		for (int i = 0; i <= N; i++)
			maxCost[i] = Integer.MAX_VALUE;

		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<Integer>());
		}

		M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			cost = Integer.parseInt(st.nextToken());

			if(!graph.get(a).contains(b))graph.get(a).add(b);
			costs[a][b] = Math.min(costs[a][b], cost);
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());

		System.out.println(bfs(start, end, 0));
	}

	static int bfs(int start, int end, int cost) {
		PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
		q.offer(new int[] { start, cost });
		maxCost[start] = 0;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int curStart = cur[0], curCost = cur[1];

			if (curCost > maxCost[curStart])
				continue;

			for (Integer next : graph.get(curStart)) {
				if (maxCost[next] > curCost + costs[curStart][next]) {
					maxCost[next] = curCost + costs[curStart][next];
					q.offer(new int[] { next, maxCost[next] });
				}
			}
		}
		return maxCost[end];
	}
}