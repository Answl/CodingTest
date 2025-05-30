import java.util.*;
class Solution {
    public int solution(String begin, String target, String[] words) {
        boolean exists = false;
        for(String word : words){
            if(word.equals(target)) {
                exists = true; break;
            }
        }
        if(!exists) return 0; 
        int size = words.length +1;
        
        List<String> wordsList = new ArrayList<>(Arrays.asList(words));
        wordsList.add(0, begin);
        
        Queue<int[]> q = new ArrayDeque<>();
        boolean[] visited = new boolean[size];
        q.offer(new int[]{0, 0});
        visited[0] = true;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int curWord = cur[0], curStep = cur[1];
            //System.out.println(wordsList.get(curWord));
            if(wordsList.get(curWord).equals(target)) return curStep;
            
            for(int i=0; i<size; i++){
                //System.out.println(diffOne(wordsList.get(i), wordsList.get(curWord)));
                if(diffOne(wordsList.get(i), wordsList.get(curWord)) && !visited[i]){
                    q.offer(new int[]{i, curStep+1});
                    visited[curWord] = true;
                }
            }
        }
        return 0;
    }
    private boolean diffOne(String s1, String s2){
        int count = 0;
        for(int i=0;i<s1.length(); i++){
            if(s1.charAt(i)!=s2.charAt(i)) count ++;
            if(count >= 2) return false;
        }
        return true;
    }
}