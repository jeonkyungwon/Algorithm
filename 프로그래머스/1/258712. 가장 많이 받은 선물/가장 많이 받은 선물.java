import java.io.*;
import java.util.*;

class Solution {
    
    static HashMap<String, Integer> map = new HashMap<>();
    static int[][] graph;
    
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        
        for (int i = 0; i <friends.length; i++) map.put(friends[i], i);
        
        int N = friends.length;
        graph = new int[N][N];
        
        for (String g : gifts) {
            String[] p = g.split(" ");
            graph[map.get(p[0])][map.get(p[1])]++;
        }
        
        int[] sent = new int[N];
        int[] rec = new int[N];
        
        for (int i = 0; i < N; i++) {
            int rs = 0, cs = 0;
            for (int j = 0; j < N; j++) {
                rs += graph[i][j];
                cs += graph[j][i];
            }
            sent[i] = rs;
            rec[i] = cs;
        }
        
        int[] giftIdx = new int[N];
        for (int i = 0; i < N; i++) giftIdx[i] = sent[i] - rec[i];
        
        int[] nextReceive = new int[N];
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (graph[i][j] > graph[j][i]) {
                    nextReceive[i]++;
                } else if (graph[i][j] < graph[j][i]) {
                    nextReceive[j]++;
                } else {
                    if (giftIdx[i] > giftIdx[j]) nextReceive[i]++;
                    else if (giftIdx[i] < giftIdx[j]) nextReceive[j]++;
                }
            }
        }
            
        for (int x : nextReceive) answer = Math.max(answer, x);
        return answer;    
    }
}