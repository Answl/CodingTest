import java.util.*;
class Solution {
    static int[] dr = {-1, 1, 0,0};
    static int[] dc = {0, 0, -1, 1};
    static int rowSize, colSize;
    public int solution(int[][] maps) {
        rowSize = maps.length;
        colSize = maps[0].length;
        
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[rowSize][colSize];
        q.offer(new int[]{0, 0, 1});
        visited[0][0] = true;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int curR = cur[0], curC = cur[1], step = cur[2];
            if(curR == rowSize-1 && curC == colSize-1) return step;
            for(int i=0; i<4; i++){
                int nextR = curR + dr[i], nextC = curC + dc[i];
                if(isInBound(nextR, nextC) && !visited[nextR][nextC]){
                    if(maps[nextR][nextC] == 1){
                        q.offer(new int[]{nextR, nextC, step+1});
                        visited[nextR][nextC] = true;
                    }
                }
            }
        }
        return -1;
    }
    private boolean isInBound(int r, int c){
        return 0<=r && r<rowSize && 0<=c && c<colSize;
    }
}