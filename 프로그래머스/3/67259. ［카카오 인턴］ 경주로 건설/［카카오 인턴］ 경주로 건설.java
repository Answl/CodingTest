import java.util.*;
import java.io.*;

class Solution {
    int[] dr = new int[]{-1, 1, 0, 0}; 
    int[] dc = new int[]{0, 0, -1, 1}; 
    // 0,1 -> 가로(0) / 2,3 -> 세로(1)
    int answer = Integer.MAX_VALUE;
    int[][][] memo;
    
    public int solution(int[][] board) {
        memo = new int[board.length][board[0].length][2];
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                for(int k=0; k<2; k++){
                    memo[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }
        
        bfs(0, 0, 0, board);
        // for(int[][] me : memo){
        //     for(int[] m : me){
        //         System.out.println(Arrays.toString(m));
        //     }
        // }
        
        return answer;
    }
    
    private void bfs(int r, int c, int cost, int[][] board){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{r, c, cost, 0});
        
        int costTmp = 100;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int prevR = cur[0], prevC = cur[1], prevCost = cur[2], prevDir = cur[3];
            
            if(prevR == board.length-1 && prevC == board[0].length-1){
                answer = Math.min(answer, prevCost);
                continue;
            }
            
            for(int i=0; i<4; i++){
                int nextR = prevR + dr[i];
                int nextC = prevC + dc[i];
                
                if(inBound(nextR, nextC, board) && board[nextR][nextC] == 0){
                    if((prevDir == 0 || prevDir == 1)&&(i == 0 || i == 1) 
                      || (prevDir == 2 || prevDir == 3)&&(i == 2 || i == 3)
                      || (prevR == 0 && prevC == 0)){
                        if((memo[nextR][nextC][0] >= prevCost + 100)) {
                            memo[nextR][nextC][0] = prevCost + 100;
                            q.offer(new int[]{nextR, nextC, memo[nextR][nextC][0], i});
                        }
                    }
                    else {
                        if((memo[nextR][nextC][1] >= prevCost + 600)) {
                            memo[nextR][nextC][1] = prevCost + 600;
                            q.offer(new int[]{nextR, nextC, memo[nextR][nextC][1], i});
                        }
                    }     
                }
            }
        }
    }
    
    private boolean inBound(int r, int c, int[][] board){
        return 0<=r && r<board.length && 0<=c && c<board[0].length;
    }
}