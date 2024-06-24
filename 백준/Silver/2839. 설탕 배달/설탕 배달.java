import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		
		int[] coin = new int[N / 5 + 1];

		for (int i = 0; i <= N / 5; i++) {
			coin[i] = i;
		}
		
		int cnt = 0;
		int check = 0;
		
		for (int i = N / 5; i >= 0; i--) {
			cnt = coin[i];
			N -= cnt * 5;
			
			if(N % 3 == 0) {
				cnt += N / 3;
				check = 1;
				break;
			} else {
				N += cnt * 5;
			}
		}
		
		if(check == 1) {
			System.out.println(cnt);
		} else {
			System.out.println(-1);
		}
	}
}