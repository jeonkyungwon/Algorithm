import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int N = routes.length;
        Arrays.sort(routes, (a, b) -> a[1] - b[1]);
        
        int answer = 1, camera = routes[0][1];
        for (int i = 1; i < N; i++) {
            if (camera < routes[i][0]) {
                answer++;
                camera = routes[i][1];
            }
        }
        
        return answer;
    }
}