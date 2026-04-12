import java.util.*;
import java.io.*;

public class Main {
    static int min;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        /**
         * 2 -> ㅃㅐ기1
         * 3 -> 3으로 나누기
         * 4 -> 나누기 2
         * 5 -> (-1) 4 나누기 2
         * 6 -> 나누기2 하고 나누기3 아니면 나누기3 하고 빼기1
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        int[] dp = new int[x+1];

        min = Integer.MAX_VALUE;
        dfs(x, 0);

        System.out.println(min);
    }

    private static void dfs(int n, int count) {
        if (count >= min) return;

        if (n == 2) {
            min = Math.min(min, count+1);
            //System.out.println("min="+ min);
            return;
        }

        if (n == 1) {
            min = Math.min(min, count);
            //System.out.println("min="+ min);
            return;
        }

        if (n % 3 == 0) {
            //System.out.println("%3");
            dfs(n/3, count+1);
        }


        if (n % 2 == 0) {
            //System.out.println("%2");
            dfs(n/2, count+1);
        }

        //System.out.println("-1");
        dfs(n - 1, count+1);
    }
}