import java.util.*;

class Solution {
    public int[] dr = {-1,0,0,1};
    public int[] dc = {0,1,-1,0};
    
    public int solution(int[][] maps) {
        int answer = 0;
        
        int m = maps.length;
        int n = maps[0].length;
        
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0,0,1}); //r,c,값
        
        boolean[][] visited = new boolean[m][n];
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            
            if(cur[0] == m-1 && cur[1] == n-1) return cur[2];
            
            for(int i=0; i<4; i++){
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];
                
                if(0<=nr && nr < m && 0<=nc && nc < n && !visited[nr][nc]){
                    if(maps[nr][nc] != 0){
                        queue.add(new int[]{nr, nc, cur[2]+1});
                        visited[nr][nc] = true;
                    }
                }
            }
        }
        
        return -1;
    }
}