import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int P = Integer.parseInt(br.readLine());
    	
    	for (int p = 0; p < P; p++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		int T = Integer.parseInt(st.nextToken());
    		
    		List<Integer> line = new ArrayList<>(20);
    		int cnt = 0;
    		
    		for (int i = 0; i < 20; i++) {
    			int student = Integer.parseInt(st.nextToken());
    			int back = line.size();
    			
    			for (int j = 0; j < line.size(); j++) {
    				if (line.get(j) > student) {
    					back = j;
    					break;
    				}
    			}
    			
    			cnt += line.size() - back;
    			line.add(back, student);
    		}

    		System.out.println(T + " " + cnt);
    	}
    }
}