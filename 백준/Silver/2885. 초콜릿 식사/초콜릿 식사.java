import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int K = Integer.parseInt(br.readLine());

        // size
        int i = 0, size = 0;
        while(true){
            if(K > Math.pow(2, i)) {
                i++;
                continue;
            }
            size = (int) Math.pow(2, i);
            sb.append(size).append(" ");
            break;
        }

        // cutCount
        int cutCount = 0;
        while(true){
            if(K == size){
                sb.append(cutCount);
                break;
            } else if(K > size){
                K -= size;
            }
            size /= 2;
            cutCount ++;
        }

        System.out.println(sb);
    }
}