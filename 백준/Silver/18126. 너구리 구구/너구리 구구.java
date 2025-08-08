import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static long max;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<List<int[]>> list = new ArrayList<>();
        visited = new boolean[N+1];

        for(int i=0; i<=N; i++){
            list.add(new ArrayList<>());
        }

        for(int i=0; i<N-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            list.get(start).add(new int[]{end, num});
            list.get(end).add(new int[]{start, num});
        }

        dfs(1, 0, list);
        System.out.println(max);
    }

    private static void dfs(int start, long sum, List<List<int[]>> list){
        visited[start] = true;
        max = Math.max(sum, max);

        for(int[] li : list.get(start)){
            if(!visited[li[0]]) dfs(li[0], sum + li[1], list);
        }
    }
}