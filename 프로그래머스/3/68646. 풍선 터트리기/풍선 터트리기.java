class Solution {
    public int solution(int[] a) {
        int answer = 2;
        int len = a.length;
        
        if (len == 1) return 1;
        
        int[] left = new int[len];
        int minL = a[0], minR = a[len - 1];
        // 왼쪽
        for (int i = 1; i < len - 1; i++) {
            minL = Math.min(minL, a[i]);
            if (minL < a[i]) left[i] = 1;
        }
       
        // 오른쪽
        for (int i = len - 2; i > 0; i--) {
            minR = Math.min(minR, a[i]);
            if (minR < a[i] && left[i] == 1) continue;
            answer++;
        }
        
        return answer; 
    }
}