import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{truck_weights[0], 1});
        int time = 1, sum = truck_weights[0], i=1;
        while(!q.isEmpty()){
            time ++;
            if(q.peek()[1] + bridge_length == time) {
                sum -= q.peek()[0];
                q.poll();
            }
            //System.out.println(time + " " + q + " " + i);
            
            if(q.size() >= bridge_length) continue;
            if(i > truck_weights.length-1) continue;
            
            if(sum + truck_weights[i] > weight) continue;
            q.offer(new int[]{truck_weights[i], time});
            sum += truck_weights[i++];
            //System.out.println(time + " " + q);
        }
        //System.out.println(time);
        
        return time;
    }
}