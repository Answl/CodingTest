import java.util.*;
class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new ArrayDeque<>();
        
        for(int j=0; j<n; j++){
            if(visited[j]) continue;
            
            visited[j] = true;
            queue.add(j);
            
            while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int i=0; i<n; i++){
                if(i == cur) continue;
                if(computers[cur][i]==1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
        answer ++;
        }
        
        return answer;
    }
}