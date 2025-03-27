import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int answer = 0;

        if(a > 0 && b > 0) answer = 1;
        else if(a < 0 && b > 0) answer = 2;
        else if(a < 0 && b < 0) answer = 3;
        else answer = 4;

        System.out.println(answer);
    }
}
