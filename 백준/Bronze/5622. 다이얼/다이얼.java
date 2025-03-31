import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = 0;
        for(char ch : br.readLine().toCharArray()){
            int i = (int) ch;
            if(i>=65 && i<=67) count += 3;
            else if(i<=70) count += 4;
            else if(i<=73) count += 5;
            else if(i<=76) count += 6;
            else if(i<=79) count += 7;
            else if(i<=83) count += 8;
            else if(i<=86) count += 9;
            else if(i<=90) count += 10;
        };
        System.out.println(count);
    }
}