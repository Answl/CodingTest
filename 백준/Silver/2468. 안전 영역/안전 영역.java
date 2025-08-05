import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];

        // 데이터 저장
        int max = 0;
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;
                max = Math.max(max, num);
            }
        }

        // for문
        int countMax = 0;
        for(int height=0; height<=max; height++){
            countMax = Math.max(countMax ,bfs(arr, height));
        }
        System.out.println(countMax);
    }

    private static int bfs(int[][] arr, int height){
        int count = 0;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(arr[i][j] > height && !visited[i][j]){
                    q.offer(new int[]{i,j});
                    visited[i][j] = true;

                    while(!q.isEmpty()){
                        int[] cur = q.poll();
                        int curR = cur[0],  curC = cur[1];
                        for(int k=0; k<4; k++){
                            int nextR = curR + dr[k];
                            int nextC = curC + dc[k];
                            if(isInBound(nextR, nextC) && arr[nextR][nextC] > height && !visited[nextR][nextC]){
                                q.offer(new int[]{nextR, nextC});
                                visited[nextR][nextC] = true;
                            }
                        }
                    }
                    count ++;
                }
            }
        }
        return count;
    }

    private static boolean isInBound(int r, int c){
        return r >= 0 && r < N && c >= 0 && c < N;
    }
}