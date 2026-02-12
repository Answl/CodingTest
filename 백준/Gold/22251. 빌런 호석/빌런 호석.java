import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] led = {
            0b1111110, //0
            0b0000110, //1
            0b1011011, //2
            0b1001111, //3
            0b0100111, //4
            0b1101101, //5
            0b1111101, //6
            0b1000110, //7
            0b1111111, //8
            0b1101111  //9
    };
    static int[][] diff = new int[10][10];

    static int N, K, P, X;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //1부터 n까지
        K = Integer.parseInt(st.nextToken()); //자릿수
        P = Integer.parseInt(st.nextToken()); //최대 반전 수
        X = Integer.parseInt(st.nextToken()); //현재 층

        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                diff[i][j] = Integer.bitCount(led[i]^led[j]);
            }
        }

        //10의 거듭제곱 계산
        int[] pow10 = new int[K+1];
        pow10[0] = 1;
        for(int i=1; i<=K; i++){
            pow10[i] = pow10[i-1]*10;
        }

        int result = 0;
        for(int i=1; i<=N; i++){
            if(i == X) continue;

            int change = 0;
            for(int j=0; j<K; j++){
                int cur = (X/pow10[j])%10;
                int tmp = (i/pow10[j])%10;

                change += diff[cur][tmp];

                if(change > P) break;
            }

            if(change > 0 && change <= P) result ++;
        }
        System.out.println(result);
    }
}
