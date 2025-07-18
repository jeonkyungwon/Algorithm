import java.util.Scanner;

public class Main {

	static int N;
	static StringBuffer bf;
	public static void main(String[] args) {
		Scanner scann=new Scanner(System.in);
		N=scann.nextInt();
		bf=new StringBuffer();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j <i+1; j++) {
				bf.append("*");
			}
			bf.append("\n");
		}
		System.out.println(bf.toString());
	}

}