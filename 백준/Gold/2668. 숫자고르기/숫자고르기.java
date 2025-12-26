import java.util.*;
import java.io.*;

public class Main {
    public static List<Integer> list = new ArrayList<>();
    public static boolean flag;
    public static boolean[] visited;
    public static Set<Integer> visitList;
    public static List<Integer> resultList = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        visited = new boolean[N+1];

        list.add(0);
        for(int i=1; i<=N; i++){
            int M = Integer.parseInt(br.readLine());
            list.add(M);
        }

//        System.out.println(list);

        for(int i=1; i<=N; i++){
            flag = false;

            visitList = new HashSet<>();
            checkCycle(i, list.get(i));
//            System.out.println(visitList);

            visited[i] = true;
            for(int vl : visitList){
                if(flag) resultList.add(vl);
                else visited[vl] = false;
            }
            if(flag) resultList.add(i);
        }

        Collections.sort(resultList);
        
        System.out.println(resultList.size());
        for(int rl : resultList){
            System.out.println(rl);
        }
    }

    private static void checkCycle(int start, int tmp){
        if(visited[tmp]) return;

        if(start == tmp) {
            flag = true;
            return;
        }
        visited[tmp] = true;
        visitList.add(tmp);

        checkCycle(start, list.get(tmp));
    }
}