class Solution {
    public long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;
        
        long min = Long.MAX_VALUE;
        for(int time : times){
            min = Math.min(min, time);
        }
        
        long left = 1;
        long right = min * n;
        long mid = 0;
        
        while(left <= right){
            mid = (left + right) / 2;
            
            long count = 0;
            for(int time : times){
                count += (mid/time);
            }
            
            if(count < n){
                left = mid + 1;
            } else {
                answer = mid;
                right = mid - 1;
            } 
        }
        
        return answer;
    }
}