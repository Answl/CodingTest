import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] num = {0, 1, 3, 6, 10, 15, 21, 28, 36, 45};

        Long l = Long.parseLong(st.nextToken());
        Long u = Long.parseLong(st.nextToken());

        long sum1 = 0, sum2 = 0;

        l--;
        long digit1 = 1;
        while(l >= digit1){
            long left = l / (digit1 * 10), cur = (l / digit1) % 10, right = l % digit1;

            sum1 += left * 45 * digit1 + cur * (right+1);
            if(cur != 0) sum1 += num[(int) cur-1] * digit1;
            digit1 *= 10;
        }
        //System.out.println(sum1);

        long digit2 = 1;
        while(u >= digit2){
            long left = u / (digit2 * 10), cur = (u / digit2) % 10, right = u % digit2;

            sum2 += left * 45 * digit2 + cur * (right+1);
            if(cur != 0) sum2 += num[(int) cur-1] * digit2;
            digit2 *= 10;
        }
        //System.out.println(sum2);

        System.out.println(sum2 - sum1);
    }
}