import java.util.*;
class Solution {
    public int solution(String begin, String target, String[] words) {
        boolean existsTg = false;
        for(int i = 0; i < words.length ; i++){
            if(words[i].equals(target)) existsTg = true;
        }
        //없으면 
        if(!existsTg) return 0;
        
        Queue<int []> q = new ArrayDeque<>();
        boolean[] visited = new boolean[words.length];
        q.offer(new int[]{-1, 0});
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            String curWord = (cur[0] == -1) ? begin : words[cur[0]];
            int curStep = cur[1];
            
            if(curWord.equals(target)) return curStep;
            
            for(int i = 0; i < words.length ; i++){
                //한글자 빼고 같으면
                if(canChange(curWord, words[i])){
                    q.offer(new int[]{i, curStep+1});
                    visited[i] = true;
                }
            }
        }
        
        return 0;
    }
    private boolean canChange(String start, String end){
        int notSameCnt = 0;
        for(int i = 0; i < start.length() ; i++){
            if(start.charAt(i) != end.charAt(i)) notSameCnt += 1;
        }
        return (notSameCnt == 1) ? true : false;
    }
}