import java.io.*;
import java.util.*;

public class Main {
	
	static int N, T, P;
	static List<Integer> rank = new ArrayList<>();

	public static void main(String[] args) throws IOException {        
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	N = Integer.parseInt(st.nextToken());
    	T = Integer.parseInt(st.nextToken());
    	P = Integer.parseInt(st.nextToken());
    	
    	if (N == 0) System.out.println(1);
    	else {
			st = new StringTokenizer(br.readLine());    	
	    	for (int n = 0; n < N; n++) {
	    		rank.add(Integer.parseInt(st.nextToken()));
	    	}
	    	
	    	rank.sort(Collections.reverseOrder());
	    	System.out.println(checkRank());
    	}
    }
	
	static int checkRank() {		
		if (T <= Collections.min(rank) && N == P) return -1;

		int ranking = 1;
		for (int i = 0; i < N; i++) {
			if (T < rank.get(i)) {
				ranking++;
			} else return ranking;
		}
		
		if (N < P) return N + 1;	
		return -1;
	}
}