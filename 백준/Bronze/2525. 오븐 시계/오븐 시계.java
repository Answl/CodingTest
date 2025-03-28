import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int time = Integer.parseInt(br.readLine());
        
        H += ((M+time)/60);
        M = (M+time)%60;

        if(H>=24) H-=24;
        
        System.out.println(H+" "+M);
    }
}