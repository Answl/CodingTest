import java.util.*;
class Solution {
    public long solution(int n) {
        int[] sum = new int[n+1]; sum[1] = 1;
        for(int i=2; i<=n; i++){
            if(i==2) {
                sum[2] = 2;
                continue;
            }
            sum[i] = (sum[(i-1<0)? 0 : i-1] + sum[(i-2<0)? 0 :i-2])
                % 1234567;
        }
        return sum[n];
    }
}