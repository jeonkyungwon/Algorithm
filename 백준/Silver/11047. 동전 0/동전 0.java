import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		int K = scan.nextInt();
		
		int[] CoinArr = new int[N];
	
		for (int i = 0; i < N; i++) {
			CoinArr[i] = scan.nextInt();
		}
		
		int cnt = 0;
		int total = 0;
		
		for (int i = N - 1; i >= 0; i--) {
			if (CoinArr[i] <= K) {
				while (total <= K) {
					total += CoinArr[i];
					cnt += 1;
				}
				total -= CoinArr[i];
				cnt -= 1;
			}
			
			if(total == K) {
				break;
			}
		}
		
		System.out.println(cnt);
	}
}