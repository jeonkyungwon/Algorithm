import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		
		int[][] time = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			int S = scan.nextInt();
			int E = scan.nextInt();
			
			time[i][0] = S;
			time[i][1] = E;
		}
		
		Arrays.sort(time, (a, b) -> {
            if (a[1] == b[1]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });

        int cnt = 0;
        int endTime = 0;

        for (int i = 0; i < N; i++) {
            if (time[i][0] >= endTime) {
                endTime = time[i][1];
                cnt++;
            }
        }

        System.out.println(cnt);
	}
}