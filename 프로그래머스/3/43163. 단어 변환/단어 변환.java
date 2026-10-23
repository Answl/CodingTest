import java.util.*;
class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{-1, 0});
        
        boolean[] visited = new boolean[words.length];
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            //System.out.println(cur[0] +" " + cur[1]);
            if(cur[0] != -1 && words[cur[0]].equals(target)) return cur[1];
            
            for(int i=0; i<words.length; i++){
                if(visited[i]) continue;
                
                int count = 0;
                String cs = (cur[0] == -1)? begin : words[cur[0]];
                for(int j=0; j<words[i].length(); j++){
                    if(cs.charAt(j) != words[i].charAt(j)) count++;
                }
                if(count != 1) continue;
                
                q.offer(new int[]{i, cur[1]+1});
                visited[i] = true;
            }
        }
        
        return answer;
    }
}