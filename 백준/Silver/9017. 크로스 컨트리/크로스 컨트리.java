import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            Map<Integer, Integer> teams = new HashMap<>();
            List<Integer> ranking = new ArrayList<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int num = Integer.parseInt(st.nextToken());
                ranking.add(num);
                teams.put(num, teams.getOrDefault(num, 0) + 1);
            }

            Map<Integer, Integer> finishCnt  = new HashMap<>();
            Map<Integer, Integer> score      = new HashMap<>();
            Map<Integer, Integer> fifthScore = new HashMap<>();

            int s = 1;
            for (int rank : ranking) {
                if (teams.getOrDefault(rank, 0) < 6) continue;

                int cnt = finishCnt.getOrDefault(rank, 0) + 1;
                finishCnt.put(rank, cnt);

                if (cnt <= 4) {
                    score.put(rank, score.getOrDefault(rank, 0) + s);
                } else if (cnt == 5) {
                    fifthScore.put(rank, s);
                }
     
                s++;
            }

            int winner = -1;
            int bestSum = Integer.MAX_VALUE;
            int bestFifth = Integer.MAX_VALUE;

            for (int team : score.keySet()) {
                int sum = score.get(team);
                int fifth = fifthScore.getOrDefault(team, Integer.MAX_VALUE);

                if (sum < bestSum || (sum == bestSum && fifth < bestFifth)) {
                    bestSum = sum;
                    bestFifth = fifth;
                    winner = team;
                }
            }

            System.out.println(winner);
        }
    }
}