import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 초기화
        List<List<Integer>> heightList = new ArrayList<>();
        List<List<Integer>> reverseList = new ArrayList<>();
        for(int i=0; i<N; i++){
            heightList.add(new ArrayList<>());
            reverseList.add(new ArrayList<>());
        }

        // List 생성
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            heightList.get(parent-1).add(child-1);
            reverseList.get(child-1).add(parent-1);
        }

        int count = 0;
        for(int i=0; i<N; i++){
            if(goNode(heightList, i, N) + comeNode(reverseList, i, N) == N-1) count ++;
        }
        System.out.println(count);
    }

    static private int goNode(List<List<Integer>> heightList, int start, int N){
        int goNodeCnt = 0;

        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[N];
        q.offer(start);
        visited[start] = true;

        while(!q.isEmpty()){
            int cur = q.poll();
            for(Integer i : heightList.get(cur)){
                if(!visited[i]) {
                    q.offer(i);
                    visited[i] = true;
                    goNodeCnt ++;
                }
            }
        }
        return goNodeCnt;
    }

    static private int comeNode(List<List<Integer>> reverseList, int start, int N){
        int comeNodeCnt = 0;

        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[N];

        q.offer(start);
        visited[start] = true;

        while(!q.isEmpty()){
            int cur = q.poll();
            for(Integer i : reverseList.get(cur)){
                if(!visited[i]) {
                    q.offer(i);
                    visited[i] = true;
                    comeNodeCnt ++;
                }
            }
        }
        return comeNodeCnt;
    }
}
