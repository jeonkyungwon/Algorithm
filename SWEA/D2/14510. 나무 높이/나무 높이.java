import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    
    static int T;
    static int[] tree;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= T; t++) {
        	int N = Integer.parseInt(br.readLine());
        	tree = new int[N];
        	int maxHeight = 0;
        	
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	for (int n = 0; n < N; n++) {
        		tree[n] = Integer.parseInt(st.nextToken());	
        		maxHeight = Math.max(maxHeight, tree[n]);
        	}
        	
        	int odd = 0, even = 0;
        	for (int n = 0; n < N; n++) {
        		int diff = maxHeight - tree[n];
        		if (diff % 2 == 1) odd++;
        		even += diff / 2;
        	}
        	
        	int needOdd = odd == 0 ? 0 : 2 * odd - 1;
            int sum = 2 * even + odd;
            int needMix = (sum / 3) * 2;

            if (sum % 3 == 1) needMix += 1;
            else if (sum % 3 == 2) needMix += 2;
            
        	int day = Math.max(needOdd, needMix);
        	
        	System.out.println("#" + t + " " + day);
        }   
    }
}