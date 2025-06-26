import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] stones = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            stones[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken()) - 1;
        int end = Integer.parseInt(st.nextToken()) - 1;

        Queue<int[]> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[N];

        queue.offer(new int[]{start, 0});
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int pos = cur[0];
            int cnt = cur[1];

            if (pos == end) {
                System.out.println(cnt);
                return;
            }

            int step = stones[pos];

            for (int i = 1; pos + step * i < N; i++) {
                int next = pos + step * i;
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(new int[]{next, cnt + 1});
                }
            }

            for (int i = 1; pos - step * i >= 0; i++) {
                int next = pos - step * i;
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(new int[]{next, cnt + 1});
                }
            }
        }

        // 도달 못한 경우
        System.out.println(-1);
    }
}
