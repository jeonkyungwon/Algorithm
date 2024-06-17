import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		
		int[] Switch = new int[N];
		for(int i = 0; i < N; i++) {
			Switch[i] = scan.nextInt();
		}

		int M = scan.nextInt();

		for(int i = 0; i < M; i++) {
			int S = scan.nextInt();
			int num = scan.nextInt();
			
			if(S == 1) {
				for(int j = 0; j < N; j++) {
					if((j + 1) % num == 0) {
						if(Switch[j] == 0) {
							Switch[j] = 1;
						}
						else {
							Switch[j] = 0;
						}
					}
				}
			}
			else {
				int j = 1;
				
				if(Switch[num - 1] == 0) {
					Switch[num - 1] = 1;
				}
				else {
					Switch[num -1 ] = 0;
				}
				if((num - 1 - j >= 0) && (num - 1 + j < N)) {
					while (Switch[num - 1 - j] == Switch[num - 1 + j]) {
						if(Switch[num - 1 - j] == 0) {
							Switch[num - 1 - j] = 1;
						}
						else {
							Switch[num - 1 - j] = 0;
						}
						if(Switch[num - 1 + j] == 0) {
							Switch[num - 1 + j] = 1;
						}
						else {
							Switch[num - 1 + j] = 0;
						}
						j += 1;
						if((num - 1 - j < 0) || (num - 1 + j >= N)) {
							break;
						}
					}
				}
			}
		}
		
		for(int i = 0; i < N; i++) {
			if(i != 0 && i % 20 == 0) {
				System.out.println();
			}
			System.out.print(Switch[i] + " ");
		}
	}
}