import java.io.*;
import java.util.*;

class Solution {
    
    static HashMap<String, Integer> cars = new HashMap<>();
    static HashMap<String, Integer> pay = new HashMap<>();
    
    public int[] solution(int[] fees, String[] records) {
        int dt = fees[0], df = fees[1], ut = fees[2], uf = fees[3];
        
        cars.clear();
        pay.clear();
        
        for (int i = 0; i < records.length; i++) {
            String[] info = records[i].split(" ");
            String[] t = info[0].split(":");
            int time = Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
            String carNum = info[1];
            
            if ("IN".equals(info[2])) {
                cars.put(carNum, time);
            } else {
                int inTime = cars.get(carNum);
                int pt = time - inTime;
                cars.remove(carNum);
                
                if (pay.containsKey(carNum)) {
                    pay.replace(carNum, pay.get(carNum) + pt);
                } else {
                    pay.put(carNum, pt);
                }
            }
        }
        
        int endOfDay = 23 * 60 + 59;
        for (String carNum : cars.keySet()) {
            int inTime = cars.get(carNum);
            int pt = endOfDay - inTime;
            if (pay.containsKey(carNum)) {
                pay.replace(carNum, pay.get(carNum) + pt);
            } else {
                pay.put(carNum, pt);
            }
        }
        
        List<String> carList = new ArrayList<>(pay.keySet());
        Collections.sort(carList);
        
        int[] answer = new int[carList.size()];
        int idx = 0;
        
        for (String carNum : carList) {
            int totalTime = pay.get(carNum);
            int fee = df;
            
            if (totalTime > dt) {
                int extra = totalTime - dt;
                int units = (extra + ut - 1) / ut;
                fee += units * uf;
            }
            
            answer[idx] = fee;
            idx++;
        }
        
        return answer;
    }
}
