import java.util.*;

class Solution {    
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        String answer = "";
        
        for (String str : participant) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        
        for (String str : completion) {
            map.put(str, map.get(str) - 1);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() != 0) {
                return entry.getKey();
            }
        }
        
        return answer;
    }
}