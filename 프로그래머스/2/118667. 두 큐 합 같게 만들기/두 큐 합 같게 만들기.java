import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();

        int len = queue1.length;
        long sum1 = 0, sum2 = 0;

        for (int i = 0; i < len; i++) {
            q1.offer(queue1[i]);
            sum1 += queue1[i];
            q2.offer(queue2[i]);
            sum2 += queue2[i];
        }

        if ((sum1 + sum2) % 2 == 1) return -1;

        long target = (sum1 + sum2) / 2;
        int answer = 0, cnt = 0;
        
        while (sum1 != target && cnt < len * 4) {
            if (sum1 > target) {
                int a = q1.poll();
                q2.offer(a);
                sum1 -= a;
            } else {
                int a = q2.poll();
                q1.offer(a);
                sum1 += a;
            }

            answer++;
            cnt++;
        }
    
        if (sum1 != target) return -1;
        return answer;
    }
}