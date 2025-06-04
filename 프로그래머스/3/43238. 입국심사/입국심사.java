class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        long max = 0;
        for (int time : times){
            max = Math.max(max, time);
        }
        
        long s = times[0], e = (long) n * max, mid;
        // **upper bound는 무조건 “정답이 포함되는 충분히 큰 값”**으로 잡는 게 안전
        while(s <= e) {
            mid = (s+e) /2;
            long sum = 0;
            for(int time : times) {
                sum += mid / time;
            }
            if(sum >= n) {
                //줄여
                e = mid -1;
                answer = mid;
            } else if (sum < n) {
                s = mid + 1;
            } 
        }
        return answer;
    }
}