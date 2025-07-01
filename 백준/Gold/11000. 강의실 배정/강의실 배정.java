import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Queue<int[]> reqQ = new PriorityQueue<>((a,b) -> a[0] - b[0]);

        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            reqQ.offer(new int[]{s, e});
        }
        //System.out.println(reqQ);
        Queue<Integer> resQ = new PriorityQueue<>((a,b) -> a - b);
        int[] f = reqQ.poll();
        resQ.offer(f[1]);

        while(!reqQ.isEmpty()){
            //System.out.println(resQ);
            int[] cur = reqQ.poll();
            //System.out.println(Arrays.toString(cur));
            //if(resQ.isEmpty() || cur[0] >= resQ.peek())
            if(!resQ.isEmpty() && cur[0] < resQ.peek()) {
            }
            else {
                resQ.poll();
            }
            resQ.offer(cur[1]);
        }
        System.out.println(resQ.size());
    }
}
