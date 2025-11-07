import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();

        List<Character> listS = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            listS.add(s.charAt(i));
        }

        int cnt = 0;
        for (int n = 0; n < N - 1; n++) {
            String word = br.readLine();

            List<Character> check = new ArrayList<>();
            List<Character> copyS = new ArrayList<>(listS);

            for (int i = 0; i < word.length(); i++) {
                char w = word.charAt(i);
                if (copyS.contains(w)) {
                    copyS.remove((Character) w);
                } else {
                    check.add(w);
                }
            }

            if (copyS.size() <= 1 && check.size() <= 1) cnt++;
        }

        System.out.println(cnt);
    }
}