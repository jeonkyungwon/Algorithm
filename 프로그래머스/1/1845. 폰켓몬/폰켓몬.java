import java.util.*;

class Solution {
    public int solution(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int answer = 0;
        
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        if (map.size() <= nums.length / 2) return map.size();
        else return nums.length / 2;
    }
}