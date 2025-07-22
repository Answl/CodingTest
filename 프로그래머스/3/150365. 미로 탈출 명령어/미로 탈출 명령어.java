import java.util.*;
class Solution {
    static int[] dc = {0, -1, 1, 0};
    static int[] dr = {1, 0, 0, -1};
    static char[] dchar = {'d', 'l', 'r', 'u'};
    static String imsi;
    static boolean flag;
    static boolean[][] visited;
    
    public String solution(int n, int m, int x1, int y1, int r, int c, int k) {
        flag = false;
        
        int dist = Math.abs(r - x1) + Math.abs(c - y1);
        if(k < dist || (k - dist)%2 == 1) return "impossible";
        else {
            backTracking(k, n, m, r, c, x1, y1, 0, new StringBuilder());
            if (imsi.equals("")) imsi = "impossible";
            return imsi.toString();
        }
    }
    public void backTracking(int k, int n, int m, int r, int c, int curX, int curY, int depth, StringBuilder str){
        if(curX == r && curY == c && depth == k) {
            imsi = str.toString();
            flag = true;
            return;
        }
        
        int dist = Math.abs(r - curX) + Math.abs(c - curY);
        if(depth + dist> k || flag) return;
        ///System.out.println(str);
        
        for(int i=0; i<4; i++){
            int x = curX + dr[i];
            int y = curY + dc[i];
            char char1 = dchar[i];
            
            
            if(canReach(x, y, n, m)){
                str.append(char1);
                backTracking(k, n, m, r, c, x, y, depth+1, str);
                str.deleteCharAt(str.length()-1);
            }
        }
    }
    public boolean canReach(int x, int y, int n, int m){
        return 1 <= x && x <= n && 1 <= y && y <= m;
    }
}