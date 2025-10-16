import java.io.*;
import java.util.*;

public class Main {
	
	static char[][] a;
	static int lArm, rArm, waist, lLeg, rLeg;
	static int[] heart;
	
	public static void main(String[] args) throws IOException {        
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	
    	a = new char[N][N];
    	for (int i = 0; i < N; i++) {
			String line = br.readLine();
    		for (int j = 0; j < N; j++) {
    			a[i][j] = line.charAt(j);
    		}
    	}
    	
    	// 심장 찾기
    	int i = 0;
    	boolean stop = false; 
    	while (!stop) {
    		for (int j = 0; j < N; j++) {
    			if (a[i][j] == '*') {
    				heart = new int[] {i + 1, j};
    				stop = true;
    				break;
    			}
    		}
    		i++;
    	}
    	
    	//왼팔 찾기
    	for (int j = heart[1] - 1; j >= 0; j--) {
    		if (a[heart[0]][j] == '_') {
    			lArm = heart[1] - j - 1;
    			break;
    		}
    		lArm = heart[1] - j;
    	}
    	//오른팔 찾기
    	for (int j = heart[1] + 1; j < N; j++) {
    		if (a[heart[0]][j] == '_') {
    			rArm = j - heart[1] - 1;
    			break;
    		}
    		rArm = j - heart[1];
    	}
    	//허리 찾기
    	for (int x = heart[0] + 1; x < N; x++) {
    		if (a[x][heart[1]] == '_') {
    			waist = x - heart[0] - 1;
    			//왼다리 찾기
    	    	for (int r = x; r < N; r++) {
    	    		if (a[r][heart[1] - 1] == '_') {
    	    			lLeg = r - x;
    	    			break;
    	    		}
    	    		lLeg = r - x + 1;
    	    	}
    	    	//오른다리 찾기
    	    	for (int r = x; r < N; r++) {
    	    		if (a[r][heart[1] + 1] == '_') {
    	    			rLeg = r - x;
    	    			break;
    	    		}
    	    		rLeg = r - x + 1;
    	    	}
    			
    			break;
    		}
    	}
    	
    	System.out.println(++heart[0] + " " + ++heart[1]);
    	System.out.println(lArm + " " + rArm + " " + waist + " " + lLeg + " " +rLeg);
    	}
}