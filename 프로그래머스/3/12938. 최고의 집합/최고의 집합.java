import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        if (n > s) return new int[] {-1};
        
        int v = s / n, r = s % n;
        int[] answer = new int[n];
        Arrays.fill(answer, v);
        
        for (int i = 0; i < n; i++) { 
            if (r > 0) {
                answer[i] = v + 1;
                r--;
            } else answer[i] = v;
        }
        
        Arrays.sort(answer);
        return answer;
    }
}