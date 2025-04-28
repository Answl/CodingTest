import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long G = Integer.parseInt(br.readLine());

        long range = (G+1)/2 -1;
        boolean isFalse = true;
        for(long i=1; i<=range; i++){
            long remember = i*i;
            double cur = Math.sqrt(G+remember);
            if(cur == (long)cur){
                System.out.println((long) cur);
                isFalse = false;
            }
        }
        if(isFalse){
            System.out.println(-1);
        }
    }
}
