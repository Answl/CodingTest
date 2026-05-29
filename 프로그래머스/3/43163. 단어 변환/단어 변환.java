import java.util.*;
class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        //타겟이 워드에 없는 경우
        boolean flag = false;
        for(String w : words){
            if(w.equals(target)) {
                flag = true;
                break;
            }
        }
        if(!flag) return 0;
        
        //있는 경우
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{-1, 0});
        boolean[] visited = new boolean[words.length];
        while(!queue.isEmpty()){
            String cur = "";
            int[] c = queue.poll();
            if(c[0] == -1) cur = begin;
            else cur = words[c[0]];
            //System.out.println(cur + " " + c[1]);
            
            if(cur.equals(target)) return c[1];
            
            for(int j=0; j<words.length; j++){
                int count = 0;
                
                if(visited[j]) continue;
                for(int i=0; i<words[j].length(); i++){
                    if(words[j].charAt(i)!=cur.charAt(i)) count++;
                }
                if(count==1) {
                    queue.add(new int[]{j, c[1]+1});
                    visited[j] = true;
                }
            }
        }
        
        return answer;
    }
}