import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;
        long max =0;
        for(int t : times) max = Math.max(t, max);
        
        long left = 0, right = max * n;
        
        while(left <= right){
            long mid = (left + right) / 2;
            
            long value = 0;
            for(int t : times){
                value += (mid / t);
            }
            
            if(value >= n) {
                right = mid-1;
                answer = Math.min(answer, mid);
            } else {
                left = mid + 1;
            }
        }
        
        return answer;
    }
}
// 0-7  7-14 14-21 21-28
// 0-10 10-20 
// 최대는 times의 가장 큰 값 * n / 길이
// 30 / 7 = 4
// 30 / 10 = 3 -> 7명
// 크거나 같으면 줄여.
    