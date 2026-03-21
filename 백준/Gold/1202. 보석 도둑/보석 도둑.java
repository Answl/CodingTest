import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<int[]> list = new ArrayList<>();

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list.add(new int[]{m, v});
        }

        Collections.sort(list, (a,b) -> a[0]-b[0]);

//        for(int[] l : list){
//            System.out.println(Arrays.toString(l));
//        }

        int[] array = new int[K];
        for(int i=0; i<K; i++){
            array[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(array);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            if(a[1]==b[1]) return a[0]-b[0];
            return -a[1]+b[1];
        });

//        int total = 0;
//        int a = 0;
//        for(int i=0; i<list.size(); i++){
//            if(a>=K || array[a] < list.get(i)[0]){
//                a++;
//                total += pq.poll()[1];
//                System.out.println(a+" "+total);
//            }
//            pq.offer(new int[]{list.get(i)[0], list.get(i)[1]});
//        }

        int tmp = 0;
        long sum = 0;
        for(int a : array){
            for(int i=tmp; i<list.size(); i++){
                if(a >= list.get(i)[0]){
                    pq.offer(new int[]{list.get(i)[0], list.get(i)[1]});
                    tmp++;
                } else {
                    tmp = i;
                    break;
                }
            }
//            System.out.println(a);
//            System.out.println(pq);

            if(!pq.isEmpty()) {
//                System.out.println(pq.peek()[1]);
                sum += pq.poll()[1];
            }
        }
        System.out.println(sum);
        //System.out.println(total);
    }
}
