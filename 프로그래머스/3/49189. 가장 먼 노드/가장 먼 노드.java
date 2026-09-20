import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        int max = Integer.MIN_VALUE;
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0; i<n+1; i++) list.add(new ArrayList<>());
        
        for(int[] ed : edge){
            list.get(ed[0]).add(ed[1]);
            list.get(ed[1]).add(ed[0]);
        }
        
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{1,1}); //수, 번호
            
        boolean[] visited = new boolean[n+1];
        visited[1] = true;
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            
            if(cur[0] > max){
                max = cur[0];
                answer = 1;
            } else if (cur[0] == max){
                answer ++;
            }
            
            for(int l : list.get(cur[1])){
                if(!visited[l]){
                    queue.offer(new int[]{cur[0]+1, l});
                    visited[l] = true;
                }
            }
        }
        
        
        return answer;
    }
}