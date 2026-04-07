import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] count = new int[26];

        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            count[name.charAt(0) - 'a']++;
        }

        boolean found = false;
        
        for (int i = 0; i < 26; i++) {
            if (count[i] >= 5) {
                System.out.print((char)(i + 'a'));
                found = true;
            }
        }

        if (!found) System.out.println("PREDAJA");
    }
}