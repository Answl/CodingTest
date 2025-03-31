import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuffer sb_a = new StringBuffer(st.nextToken());
        StringBuffer sb_b = new StringBuffer(st.nextToken());

        int aNum = Integer.parseInt(sb_a.reverse().toString());
        int bNum = Integer.parseInt(sb_b.reverse().toString());

        System.out.println(Math.max(aNum, bNum));
    }
}