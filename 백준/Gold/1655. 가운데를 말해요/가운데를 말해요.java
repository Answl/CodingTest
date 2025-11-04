import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Queue<Integer> q1 = new PriorityQueue<>((a, b) -> b - a);
        Queue<Integer> q2 = new PriorityQueue<>((a, b) -> a - b);

        int c1 = 0, c2 = 0;
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());
            if(!q1.isEmpty()) {
                if(q1.peek() < num) {
                    q2.add(num);
                    c2 ++;
                }
                else {
                    q1.add(num);
                    c1 ++;
                }
            }
            else {
                q1.add(num);
                c1 ++;
            }

            if(c2 - c1 >= 1) {
                q1.add(q2.poll());
                c2 --; c1 ++;
            }
            else if(c1 - c2 >= 2) {
                q2.add(q1.poll());
                c1 --; c2 ++;
            }

            sb.append(q1.peek()).append("\n");
        }
        System.out.println(sb);
    }
}