import java.util.*;
import java.io.*;

public class Main {
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};

    private static boolean[][] visited;
    private static int[][] num, dp;
    private static int N, M, result = 0;
    private static boolean flag = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        num = new int[N][M];
        dp = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<M; j++){
                if(str.charAt(j) == 'H') num[i][j] = -1; // HOLE
                else num[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
            }
        }
//        System.out.println(Arrays.deepToString(num));

        visited[0][0] = true;
        dfs(0,0, 0);

        if(flag) result = -1;
        System.out.println(result);
    }

    private static void dfs(int r, int c, int count){
        if(flag) return;
//        System.out.println("방문 " + r + c + "횟수 " + count);

        for(int i=0; i<4; i++){
            int nextR = r + dr[i]*num[r][c];
            int nextC = c + dc[i]*num[r][c];

            if(0<=nextR && nextR<N && 0<=nextC && nextC<M
            ){
                if(dp[nextR][nextC] >= count+1) continue;

                if(num[nextR][nextC] == -1){
                    result = Math.max(result, count+1);
                    continue;
                }

                if(visited[nextR][nextC]){
                    flag = true;
//                    System.out.println("방문 " + r + c + nextR + nextC + "flag " + count);
                    continue;
                }

                visited[nextR][nextC] = true;
                dp[nextR][nextC] = count+1;
                dfs(nextR, nextC, count+1);
                visited[nextR][nextC] = false;
            } else {
                result = Math.max(result, count+1);
//                visited[r][c] = false;
            }
        }
    }
}
