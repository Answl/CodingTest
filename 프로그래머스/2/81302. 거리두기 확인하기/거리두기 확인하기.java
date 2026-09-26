import java.util.*;
class Solution {
    static int[] dr = {0,0,-1,1};
    static int[] dc = {-1,1,0,0};
    public int[] solution(String[][] places) {
        
        int m = places.length, n = places[0].length;
        int[] answer = new int[m];
        
        for(int i=0; i<m; i++){
            ///System.out.println(i + "번째");
            answer[i] = check(places[i], n);
        }
        
        return answer;
    }
    
    private int check(String[] place, int n){
        //p로부터 2주변에 있는지 확인
        int k = place[0].length();
        
        for(int i=0; i<n; i++){
            for(int j=0; j<k; j++){
                if(place[i].charAt(j) == 'P'){
                    //System.out.println("p 주소: " + i + " "+ j + " " + bfs(i,j, place, n, k));
                    if(!bfs(i,j, place, n, k)) return 0;
                }
            }
        }
        return 1;
    }
    
    private boolean bfs(int i, int j, String[] place, int n, int k){
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] v = new boolean[n][k];
        
        q.offer(new int[]{i,j,0});
        v[i][j] = true;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            //System.out.println(cur[0] + " " + cur[1] + " " + cur[2]);
            if(cur[2] >= 2) continue;
            
            for(int a=0; a<4; a++){
                int nextR = cur[0] + dr[a];
                int nextC = cur[1] + dc[a];
                
                if(!(0 <= nextR && nextR < n && 0 <= nextC && nextC < k)) continue;
                if(v[nextR][nextC] || place[nextR].charAt(nextC) == 'X') continue;
                
                if(place[nextR].charAt(nextC) == 'P') return false;
                q.offer(new int[]{nextR, nextC, cur[2]+1});
                v[nextR][nextC] = true;
            }
        }
        return true;
    }
}