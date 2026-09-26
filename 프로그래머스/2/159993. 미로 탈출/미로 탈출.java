// s0000
// 00000
// 00000
// 00000
// 000LE
import java.util.*;
class Solution {
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {1, -1, 0, 0};
    
    public int solution(String[] map) {
        int answer1 = 0, answer2= 0;
        
        int m = map.length, n = map[0].length();
        
        int startR = 0, startC = 0, leverR = 0, leverC = 0, endR = 0, endC = 0;
        
        char[][] maps = new char[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                
                char c = map[i].charAt(j);
                
                if(c == 'S'){
                    startR = i; startC = j;
                }
                if(c == 'E'){
                    endR = i; endC = j;
                }
                if(c == 'L'){
                    leverR = i; leverC = j;
                }
                
                maps[i][j] = c;
            }
        }
        
        //처음 -> 레버
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{startR, startC, 0});
        
        boolean[][] visited = new boolean[m][n];
        visited[startR][startC] = true;
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            if(cur[0] == leverR && cur[1] == leverC){
                answer1 = cur[2];
                break;
            }
            for(int i=0; i<4; i++){
                int nextR = cur[0] + dr[i];
                int nextC = cur[1] + dc[i];
                
                if(!(0<=nextR && nextR < m
                   && 0<=nextC && nextC < n)) continue;
                
                if(maps[nextR][nextC] == 'X') continue;
                if(visited[nextR][nextC]) continue;
                
                queue.offer(new int[]{nextR, nextC, cur[2]+1});
                visited[nextR][nextC] = true;
                }
        }
        //System.out.println(answer1);
        if(answer1 == 0) return -1;
        
        // // 레버 -> 끝
        // for(int i=0; i<m; i++){
        //     for(int j=0; j<n; j++){
        //         visited[i][j] = false;
        //     }
        // }
        
        queue = new ArrayDeque<>();
        visited = new boolean[m][n];
        
        queue.offer(new int[]{leverR, leverC, 0});
        visited[leverR][leverC] = true;
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            if(cur[0] == endR && cur[1] == endC){
                answer2 = cur[2];
                break;
            }
            for(int i=0; i<4; i++){
                int nextR = cur[0] + dr[i];
                int nextC = cur[1] + dc[i];
                
                if(!(0<=nextR && nextR < m
                   && 0<=nextC && nextC < n)) continue;
                
                if(maps[nextR][nextC] == 'X') continue;
                if(visited[nextR][nextC]) continue;
                
                queue.offer(new int[]{nextR, nextC, cur[2]+1});
                visited[nextR][nextC] = true;
                }
        }
        //System.out.println(answer2);
        
        if(answer2 == 0) return -1;
        else return answer1 + answer2;
        }

}