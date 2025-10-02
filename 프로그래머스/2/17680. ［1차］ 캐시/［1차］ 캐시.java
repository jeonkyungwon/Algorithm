import java.io.*;
import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) return 5 * cities.length;

        int answer = 0;
        List<String> line = new ArrayList<>(cacheSize);
        
        for (String city : cities) {
            city = city.toLowerCase();
            
            if (line.contains(city)) {
                int idx = line.indexOf(city);
                line.remove(idx);
                line.add(city);
                answer++;
            } else {
                if (line.size() == cacheSize) {
                    line.remove(0);
                }
                line.add(city);
                answer += 5;
            }
        }
        
        return answer;
    }
}