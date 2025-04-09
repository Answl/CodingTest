import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    static int[][] dp = new int[15][15];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        
        for(int i=1; i<=14; i++){
            dp[0][i]=i;
        }
        
        for(int t=0; t<T; t++){
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            apartment(k,n);
        }
    }
    public static void apartment(int k, int n){
        for(int a=1; a<=k; a++){
            for(int b=1; b<=n; b++){
                dp[a][b]=dp[a-1][b]+dp[a][b-1];
            }
        }
        System.out.println(dp[k][n]);
    }
}