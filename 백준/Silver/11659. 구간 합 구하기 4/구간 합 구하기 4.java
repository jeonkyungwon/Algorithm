import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		int M = scan.nextInt();

	    int[] numArry = new int[N + 1];
	    for (int i = 1; i < N + 1; i++) {
	    	numArry[i] = scan.nextInt();
		}
	    
	    int StackSum = 0;
	    int[] SumArry = new int[N + 1];
	    for (int i = 1; i < N + 1; i++) {
	    	StackSum += numArry[i];
	    	SumArry[i] = StackSum;
	    }
	    
	    for (int a = 0; a < M; a++) {
	    	int i = scan.nextInt();
	    	int j = scan.nextInt();
	    	
	    	System.out.println(SumArry[j] - SumArry[i - 1]);
	    }
	}
}