import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        if(b>=45){
            System.out.println(a+" "+(b-45));
        }else if(a!=0 && b<45){
            System.out.println((a-1)+" "+(b+15));
        }else{
            System.out.println("23 "+(b+15));
        }
    }
}