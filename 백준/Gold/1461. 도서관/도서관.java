import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer> positive = new ArrayList<>();
        List<Integer> positiveMemo = new ArrayList<>();

        List<Integer> negative = new ArrayList<>();
        List<Integer> negativeMemo = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            int dist = Integer.parseInt(st.nextToken());
            if(dist > 0) positive.add(dist);
            else negative.add(dist);
        }

        Collections.sort(positive, (a, b) -> b - a);
        Collections.sort(negative);

        for(int i=0;i < positive.size(); i++){
            if(i%M == 0){
                positiveMemo.add(positive.get(i));
            }
        }

        for(int i=0;i<negative.size();i++){
            if(i%M == 0){
                negativeMemo.add(negative.get(i));
            }
        }
        
        int step = 0;
        int max = 0;
        for(int i=0;i<negativeMemo.size();i++){
            step += Math.abs(negativeMemo.get(i))*2;
            max = Math.max(max,Math.abs(negativeMemo.get(i)));
        }
        for(int i=0;i<positiveMemo.size();i++){
            step += positiveMemo.get(i)*2;
            max = Math.max(max,positiveMemo.get(i));
        }
        
//        System.out.println(negativeMemo);
//        System.out.println(positiveMemo);
        System.out.println(step-max);
    }
}
