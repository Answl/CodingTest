import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] charArr = br.readLine().toCharArray();
        int n = charArr.length;

        boolean[][] is_pal = new boolean[n+1][n+1];
        int[] pal = new int[n+1]; pal[0] = 0; pal[1] = 1;

        //각 char는 true
        for(int i = 0; i < n; i++) is_pal[i][i] = true;

        for(int i = 2; i <= n; i++){ //0 a b a
            pal[i] = pal[i-1] + 1; 
            for(int j = 1; j < i; j++){
                if(charArr[j-1] == charArr[i-1]){
                    if(is_pal[j+1][i-1] || j+1 == i){
                        is_pal[j][i] = true;
                        pal[i] = Math.min(pal[i], pal[j-1]+1);
                    }
                }
            }
        }
        System.out.println(pal[n]);
    }
}
