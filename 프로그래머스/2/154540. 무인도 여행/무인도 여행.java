import java.util.*;
class Solution {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0,0,-1,1};
    static boolean[][] visited;
    static int sum = 0;
    public int[] solution(String[] maps) {
        List<Integer> answer = new ArrayList<>();
        
        char[][] map = new char[maps.length][maps[0].length()];
        visited = new boolean[maps.length][maps[0].length()];
        for(int i=0; i<map.length; i++){
            map[i] = maps[i].toCharArray();
        }
        //System.out.println(Arrays.deepToString(map));
        //System.out.println('9' - '0');
        
        for(int i=0; i<maps.length; i++){
            for(int j=0; j<maps[0].length(); j++){
                if(map[i][j] != 'X' && !visited[i][j]) {
                    sum = map[i][j]-'0';
                    dfs(i, j, map);
                    answer.add(sum);
                }
            }
        }
        int i=0;
        int[] ans = new int[answer.size()];
        for(Integer a : answer){
            ans[i++] = a;
        }
        Arrays.sort(ans);
        
        return ans.length == 0? new int[]{-1} : ans;
    }
    private void dfs(int i, int j, char[][] map){
        visited[i][j] = true;
        
        for(int k=0; k<4; k++){
                int nr = i + dr[k], nc = j + dc[k];
                if(!(0 <= nr && nr < map.length && 0 <= nc && nc < map[0].length)) continue;
                if(visited[nr][nc]) continue;
                if(map[nr][nc] == 'X') continue;
                
                //visited[nr][nc] = true;
                sum += (map[nr][nc]-'0');
                dfs(nr, nc, map);
        }
    }
}