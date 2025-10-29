import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        int N = A.length;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        int a = 0, b = 0;
        while (a < N && b < N) {
            if (A[a] < B[b]) {
                a++;
                b++;
                answer++;
            } else {
                b++;
            }
        }
        
        return answer;
    }
}