import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] road = new int[N - 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
        	road[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] price = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
        	price[i] = Integer.parseInt(st.nextToken());
        }
        
        int cost = road[0] * price[0];
        int minCost = price[0];
        for (int i = 1; i < N - 1; i++) {
        	if (minCost > price[i]) {
        		minCost = price[i];
        	}
        	cost += minCost * road[i];
        }
        
        System.out.println(cost);
    } 
}