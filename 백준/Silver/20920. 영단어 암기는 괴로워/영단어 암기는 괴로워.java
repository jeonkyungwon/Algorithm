import java.io.*;
import java.util.*;

public class Main {

    static HashMap<String, Integer> map = new HashMap<>();
    static List<String> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int n = 0; n < N; n++) {
            String word = br.readLine();

            if (word.length() < M) continue;
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        list.addAll(map.keySet());

        list.sort((a, b) -> {
            int fa = map.get(a);
            int fb = map.get(b);
            if (fa != fb) return fb - fa;
            if (a.length() != b.length()) return b.length() - a.length();
            return a.compareTo(b);
        });

        StringBuilder sb = new StringBuilder();
        for (String w : list) sb.append(w).append('\n');
        System.out.print(sb.toString());
    }
}