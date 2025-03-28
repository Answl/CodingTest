import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int originScore[] = new int[N];
        
        int sumScore = 0;
        int maxScore = 0;
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0;i<N;i++){
            originScore[i] = Integer.parseInt(st.nextToken());
            maxScore = Math.max(maxScore, originScore[i]);
            sumScore += originScore[i];
        }

        double currentScore = (double) sumScore / maxScore * 100 / N;
        System.out.println(currentScore);
    }
}